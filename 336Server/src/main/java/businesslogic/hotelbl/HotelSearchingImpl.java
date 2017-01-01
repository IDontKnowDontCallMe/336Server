package businesslogic.hotelbl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.roomblservice.RoomBLService;
import dataservice.hoteldataservice.HotelDataService;
import factory.BLFactory;
import factory.DataFactory;
import po.HotelPO;
import vo.AreaVO;
import vo.HotelVO;
import vo.RoomVO;
import vo.SearchConditionVO;

public class HotelSearchingImpl {

	/**
	 * 根据商圈分类的酒店列表的cache，key为城市--商圈
	 */
	private Map<String, Map<Integer, HotelPO>> areaCache;
	/**
	 * 客户搜索结果的cache，存储了当前显示在客户界面上的酒店列表，key为customerID
	 */
	private Map<Integer, List<HotelVO>> resultCache;
	private Queue<String> areaQueue;
	private Queue<Integer> customerQueue;
	private static final int maxCache = 220;
	private static final int cleanTimes = 10;

	public HotelSearchingImpl() {
		// TODO Auto-generated constructor stub
		areaCache = new LinkedHashMap<String, Map<Integer, HotelPO>>(30, (float)0.75, false);
		resultCache = new LinkedHashMap<Integer, List<HotelVO>>(30, (float)0.75, false);
		areaQueue = new ArrayDeque<String>();
		customerQueue = new ArrayDeque<Integer>();
	}
	
	
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID) {

		if( !areaCache.containsKey(toAreaString(areaVO))){
			loadToAreaCache(areaVO);
			System.out.println(233);
		}
		
		List<HotelVO> resultList = getVOsByPOs(areaCache.get(toAreaString(areaVO)), customerID);
		addResult(customerID, resultList);
		
		return resultCache.get(customerID);
		
	}


	public List<HotelVO> search(AreaVO areaVO, SearchConditionVO searchConditionVO) {
		if( !areaCache.containsKey(toAreaString(areaVO))){
			loadToAreaCache(areaVO);
		}
		
		List<HotelVO> areaList = getVOsByPOs(areaCache.get(toAreaString(areaVO)), searchConditionVO.customerID);
		List<HotelVO> result = new ArrayList<HotelVO>();
		
		ConditionJudger conditionJudger = new ConditionJudger(searchConditionVO);
		
		for(HotelVO hotelVO: areaList){
			if(conditionJudger.satisfyWith(hotelVO)){
				result.add(hotelVO);
			}
		}
		
		addResult(searchConditionVO.customerID, result);
		
		return result;
	}


	public List<HotelVO> sort(int customerID, String sortType) {
		
		if(!resultCache.containsKey(customerID)){
			return null;
		}
		
		HotelSorter hotelSorter = new HotelSorter(sortType);
		
		List<HotelVO> result = hotelSorter.sort(resultCache.get(customerID));
		
		return result;
	}
	
	public List<HotelVO> getBookedHotelList(int customerID) {
		
		
		Map<Integer, HotelPO> map = new HashMap<Integer,HotelPO>();
		
		List<Integer> hotelID = BLFactory.getOrderBLService().getBookedHotelidOf(customerID);
		
		for(int id: hotelID){
			HotelPO hotelPO = DataFactory.getHotelDataService().getHotelInfo(id);
			map.put(hotelPO.getHotelID(), hotelPO);
		}
		
		List<HotelVO> result = getVOsByPOs(map, customerID);
		addResult(customerID, result);
		
		return result;
	}
	
	public boolean exitSearch(int customerID){
		
		if(resultCache.containsKey(customerID)){
			resultCache.remove(customerID);
		}
		
		return true;
	}
	
	public void  updateAreaCache(String oldBussinessCircle, HotelVO hotelVO){
		if(oldBussinessCircle.equals(hotelVO.businessCircle)){
			if(areaCache.containsKey(hotelVO.city + "--" + hotelVO.businessCircle)){
				HotelPO hotelPO = new HotelPO(hotelVO.hotelID, hotelVO.hotelName, hotelVO.city, hotelVO.businessCircle, hotelVO.address, hotelVO.introduction, hotelVO.service, hotelVO.workerName, hotelVO.phoneNumber, hotelVO.score, hotelVO.commentScore, -1, -1);
				areaCache.get(hotelPO.getCity()+ "--" + hotelPO.getBusinessCircle()).replace(hotelPO.getHotelID(), hotelPO);
			}
		}
		else if(!oldBussinessCircle.equals(hotelVO.businessCircle)){
			if(areaCache.containsKey(hotelVO.city + "--" + hotelVO.businessCircle)){
				HotelPO hotelPO = new HotelPO(hotelVO.hotelID, hotelVO.hotelName, hotelVO.city, hotelVO.businessCircle, hotelVO.address, hotelVO.introduction, hotelVO.service, hotelVO.workerName, hotelVO.phoneNumber, hotelVO.score, hotelVO.commentScore, -1, -1);
				areaCache.get(hotelPO.getCity()+ "--" + hotelPO.getBusinessCircle()).put(hotelPO.getHotelID(), hotelPO);
			}
			if(areaCache.containsKey(hotelVO.city + "--" + oldBussinessCircle)){
				areaCache.get(hotelVO.city + "--" + oldBussinessCircle).remove(hotelVO.hotelID);
			}
		}
	}
	
	//-----------------------------------------
	
	/**
	 * 从数据库中读出该商圈的酒店，放入cache
	 * @param areaVO
	 */
	private void loadToAreaCache(AreaVO areaVO){
		if(areaCache.containsKey(toAreaString(areaVO))){
			return;
		}
		
		if(areaCache.size() >= maxCache){
			cleanSomeAreaCache();
		}
		
		System.out.println("load area");
		
		HotelDataService hotelDataService = DataFactory.getHotelDataService();
		Map<Integer, HotelPO> map = hotelDataService.getHotelListOfArea(areaVO.city, areaVO.businessCircle);
		System.out.println(map.size());
		areaCache.put(toAreaString(areaVO), map);
		areaQueue.add(toAreaString(areaVO));
	}
	
	/**
	 * 清除一些最晚不被使用的商圈的酒店
	 */
	private void cleanSomeAreaCache(){
		for(int i=0; i < cleanTimes; i++){
			areaCache.remove(areaQueue.poll());
		}
	}
	
	/**
	 * 在resultCache中增加一个customer的搜索结果
	 * @param customerID
	 * @param list
	 */
	private void addResult(int customerID, List<HotelVO> list){
		if(resultCache.containsKey(customerID)){
			resultCache.replace(customerID, list);
		}
		else{
			if(resultCache.size() >= maxCache){
				cleanSomeResultCache();
			}
			resultCache.put(customerID, list);
			customerQueue.add(customerID);
		}
	}
	
	private void cleanSomeResultCache(){
		for(int i=0; i < cleanTimes; i++){
			resultCache.remove(customerQueue.poll());
		}
	}
	
	/**
	 * 把map转为对应的list
	 * @param map
	 * @param customerID
	 * @return
	 */
	private List<HotelVO> getVOsByPOs(Map<Integer, HotelPO> map , int customerID){
		List<HotelVO> result = new ArrayList<HotelVO>();
		
		if(map.size()<1) return result;
		
		OrderBLService orderBLService = BLFactory.getOrderBLService();
		for(Entry<Integer, HotelPO> entry: map.entrySet()){
			int bookedTag = orderBLService.getBookedTag(customerID, entry.getValue().getHotelID());
			int minPrice = getMinPriceOfHotel(entry.getValue().getHotelID());
			
			if(minPrice==Integer.MAX_VALUE)
				continue;
			
			HotelVO hotelVO = new HotelVO(entry.getValue().getHotelID(), entry.getValue().getHotelName(), entry.getValue().getCity(), entry.getValue().getBusinessCircle(), entry.getValue().getAddress(),entry.getValue().getIntroduction(),
					entry.getValue().getService(), entry.getValue().getScore(), entry.getValue().getCommentScore(), entry.getValue().getWorkerName(), entry.getValue().getPhoneNumber(), minPrice, bookedTag);
			result.add(hotelVO);
		}
		return result;
	}
	
	/**
	 * 根据酒店的各个房型，得出当前酒店的最小未优惠房间价格
	 * @param hotelID
	 * @return
	 */
	private int getMinPriceOfHotel(int hotelID){
		RoomBLService roomBLService = BLFactory.getRoomBLService();
		List<RoomVO> roomList = null;
		
		roomList = roomBLService.getRoomTypeList(hotelID);
		
		int minPrice = Integer.MAX_VALUE;
		if(roomList.size()>0){
			for(RoomVO roomVO: roomList){
				if(roomVO.price < minPrice)
					minPrice = roomVO.price;
			}
		}
		return minPrice;
	}
	
	/**
	 * 城市商圈的String格式化
	 * @param areaVO
	 * @return
	 */
	private String toAreaString(AreaVO areaVO){
		return areaVO.city + "--" + areaVO.businessCircle;
	}
	
	
}
