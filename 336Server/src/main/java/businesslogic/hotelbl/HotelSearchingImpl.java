package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import businesslogicservice.hotelblservice.OrderForC_H_Service;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.roomblservice.RoomBLService;
import dataservice.hoteldataservice.HotelDataService;
import factory.BLFactory;
import factory.DataFactory;
import po.HotelPO;
import vo.AreaVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;

public class HotelSearchingImpl {

	private HashMap<String, List<HotelPO>> areaCache;
	private HashMap<Integer, List<HotelVO>> resultCache;
	private Queue<String> areaQueue;
	private Queue<Integer> customerQueue;
	private static final int maxCache = 220;
	private static final int cleanTimes = 10;

	
	
	
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID) {

		if( !areaCache.containsKey(toAreaString(areaVO))){
			loadToAreaCache(areaVO);
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
		List<HotelPO> tempList = new ArrayList<HotelPO>();
		
		List<Integer> hotelID = BLFactory.getOrderBLService().getBookedHotelidOf(customerID);
		
		for(int id: hotelID){
			HotelPO hotelPO = DataFactory.getHotelDataService().getHotelInfo(id);
			tempList.add(hotelPO);
		}
		
		List<HotelVO> result = getVOsByPOs(tempList, customerID);
		addResult(customerID, result);
		
		return result;
	}
	
	//-----------------------------------------
	
	private void loadToAreaCache(AreaVO areaVO){
		if(areaCache.containsKey(toAreaString(areaVO))){
			return;
		}
		
		if(areaCache.size() >= maxCache){
			cleanSomeAreaCache();
		}
		
		HotelDataService hotelDataService = DataFactory.getHotelDataService();
		List<HotelPO> list = hotelDataService.getHotelListOfArea(areaVO.city, areaVO.businessCircle);
		areaCache.put(toAreaString(areaVO), list);
		areaQueue.add(toAreaString(areaVO));
	}
	
	private void cleanSomeAreaCache(){
		for(int i=0; i < cleanTimes; i++){
			areaCache.remove(areaQueue.poll());
		}
	}
	
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
	
	private List<HotelVO> getVOsByPOs(List<HotelPO> list , int customerID){
		List<HotelVO> result = new ArrayList<HotelVO>();
		OrderBLService orderBLService = BLFactory.getOrderBLService();
		for(HotelPO po: list){
			int bookedTag = orderBLService.getBookedTag(customerID, po.getHotelID());
			int minPrice = getMinPriceOfHotel(po.getHotelID());
			HotelVO hotelVO = new HotelVO(po.getHotelID(), po.getHotelName(), po.getCity(), po.getBusinessCircle(), po.getAddress(),po.getIntroduction(),
										po.getService(), po.getScore(), po.getCommentScore(), po.getWorkerName(), po.getPhoneNumber(), minPrice, bookedTag);
			result.add(hotelVO);
		}
		return result;
	}
	
	private int getMinPriceOfHotel(int hotelID){
		RoomBLService roomBLService = BLFactory.getRoomBLService();
		List<RoomVO> roomList = null;
		
		roomList = roomBLService.getRoomTypeList(hotelID);
		
		int minPrice = Integer.MAX_VALUE;
		for(RoomVO roomVO: roomList){
			if(roomVO.price < minPrice)
				minPrice = roomVO.price;
		}
		return minPrice;
	}
	
	private String toAreaString(AreaVO areaVO){
		return areaVO.city + "--" + areaVO.businessCircle;
	}
	
	
}
