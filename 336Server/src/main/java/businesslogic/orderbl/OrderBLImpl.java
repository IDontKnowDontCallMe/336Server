package businesslogic.orderbl;


import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import factory.BLFactory;
import data.factory.DataFactory;
import po.OrderPO;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.OrderVO;

public class OrderBLImpl  implements AbnormalObserver{

	private Map<Integer, Map<Integer,OrderPO>> orderPOCache;
	private Queue<Integer> IDQueue;
	private static final int maxCache = 220;
	
	public OrderBLImpl() {
		// TODO Auto-generated constructor stub
		orderPOCache = new LinkedHashMap<>(30, (float)0.75, false);
		IDQueue = new ArrayDeque<Integer>();
	}
	
	
	public List<OrderVO> getCustomerOrder(int customerID) {

		return getOrderListOf(customerID);
	}
	

	public List<OrderVO> getHotelOrder(int hotelID){
		
		return getOrderListOf(hotelID);
	}

	// #$%^^&&**
	public List<OrderVO> getAbnormalOrdersOfToday()  {
		
		
		return null;
	}
	

	public List<OrderVO> filterCustomerList(int customerID, String state) {

		return getFilterListOf(customerID, state);
	}

	public List<OrderVO> filterHotelList(int hotelID, String state) {

		return getFilterListOf(hotelID, state);
	}
	
	public String canBeProduced(CalculationConditionVO calculationConditionVO) {

		if(!orderPOCache.containsKey(calculationConditionVO.hotelID)){
			loadToCache(calculationConditionVO.hotelID);
		}
		
		ValidOrderJudger judger = new ValidOrderJudger(calculationConditionVO, orderPOCache.get(calculationConditionVO.hotelID));
		
		return judger.judge();
	}
	
	public int calculateTotal(CalculationConditionVO vo){

		CustomerVO customerVO = BLFactory.getCustomerBLService().getCustomerInfo(vo.customerID);
		
		int total = -1;
		
			total = BLFactory.getPromotionBLService().calculateOrder(vo, customerVO);

		return total;
	}
	

	public boolean produceOrder(OrderVO orderVO, CalculationConditionVO calculationConditionVO){

		System.out.println("produce");
		
		if(orderVO.customerID == 23333) return produceOfflineOrder(orderVO, calculationConditionVO);
		
		int orderID =  DataFactory.getOrderDataService().getNumOfAllOrders()+1+900000000 ;
		
		CustomerVO customerVO = BLFactory.getCustomerBLService().getCustomerInfo(orderVO.customerID);
		
		OrderPO orderPO = new OrderPO(orderID, customerVO.customerName, customerVO.customerID, LocalDateTime.now(), orderVO.hotelName, 
									calculationConditionVO.hotelID, orderVO.roomName, calculationConditionVO.roomNum, orderVO.hasChildren, 
				orderVO.peopleNum, orderVO.checkInTime, orderVO.lastestArrivingTime, orderVO.checkOutTime, orderVO.total, "正常", null, null, null,false);
		
		if(DataFactory.getOrderDataService().insertOrder(orderPO)){
			if(orderPOCache.containsKey(orderVO.customerID)){
				orderPOCache.get(orderVO.customerID).put(orderPO.getOrderID(), orderPO);
			}
			
			if(orderPOCache.containsKey(orderPO.getHotelID())){
				orderPOCache.get(orderPO.getHotelID()).put(orderPO.getOrderID(), orderPO);
			}
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean produceOfflineOrder(OrderVO orderVO, CalculationConditionVO calculationConditionVO){
		int orderID = orderVO.orderID == -1? DataFactory.getOrderDataService().getNumOfAllOrders()+1+900000000 : orderVO.orderID;
		
		
		OrderPO orderPO = new OrderPO(orderID, orderVO.customerName, 23333, LocalDateTime.now(), orderVO.hotelName, 
									calculationConditionVO.hotelID, orderVO.roomName, calculationConditionVO.roomNum, orderVO.hasChildren, 
				orderVO.peopleNum, orderVO.checkInTime, orderVO.lastestArrivingTime, orderVO.checkOutTime, orderVO.total, "已执行", null, LocalDateTime.now(), null,false);
		
		if(DataFactory.getOrderDataService().insertOrder(orderPO)){
			
			if(orderPOCache.containsKey(orderPO.getHotelID())){
				orderPOCache.get(orderPO.getHotelID()).put(orderPO.getOrderID(), orderPO);
			}
			return true;
		}
		else{
			return false;
		}
	}
	

	public boolean changeOrderState(int orderID, String state){
		
		OrderChanger orderChanger = new OrderChanger(orderID, state);
		
		OrderPO po = orderChanger.change();
		
		if(po!=null){
			if(orderPOCache.containsKey(po.getCustomerID())){
				orderPOCache.get(po.getCustomerID()).replace(po.getOrderID(), po);
			}
			if(orderPOCache.containsKey(po.getHotelID())){
				orderPOCache.get(po.getHotelID()).replace(po.getOrderID(), po);
			}
				
			return true;
		}
		
		return false;
	}
	
	
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		
		if(!orderPOCache.containsKey(customerID)){
			loadToCache(customerID);
		}

		Map<Integer,OrderPO> list = new HashMap<Integer,OrderPO>();
		
		System.out.println("orders");
		if(orderPOCache.get(customerID) == null || orderPOCache.get(customerID).size()<1) return new ArrayList<OrderVO>();
		
		int index = 0;
		for(Entry<Integer, OrderPO> entry: orderPOCache.get(customerID).entrySet()){
			if(entry.getValue().getHotelID() == hotelID){
				list.put(index, entry.getValue());
				index++;
			}
		}
		
		List<OrderVO> result = getVOListByPOList(list);
		
		return result;
	}

	
	public int getBookedTag(int customerID, int hotelID) {
		if(!orderPOCache.containsKey(customerID)){
			loadToCache(customerID);
		}
		
		Map<Integer,OrderPO> list = orderPOCache.get(customerID);
		
		int result = 0;
		
		if(list.size() < 0) return 0;
		
		for(Entry<Integer, OrderPO> entry: list.entrySet()){
			if(entry.getValue().getHotelID() != hotelID){
				continue;
			}
			else if(entry.getValue().getOrderState().equals("已执行未离店") || entry.getValue().getOrderState().equals("已执行已离店")) {
				result = 2;
				break;
			}
			else{
				result = 1;
				continue;
			}
		}
		
		return result;
	}


	public List<Integer> getBookedHotelidOf(int customerID) {

		if(!orderPOCache.containsKey(customerID)){
			loadToCache(customerID);
		}
		
		List<Integer> result = new ArrayList<Integer>();
		
		Map<Integer,OrderPO> orderList = orderPOCache.get(customerID);
		
		for(Entry<Integer, OrderPO> entry : orderList.entrySet()){
			result.add(entry.getValue().getHotelID());
		}
		
		return result;
	}
	
	
	
	//-------------------------------------------------------------------
	
	private List<OrderVO> getOrderListOf(int id) {
		if(!orderPOCache.containsKey(id)){
			loadToCache(id);
		}
		
		return getVOListByPOList(orderPOCache.get(id));
	}
	
	private List<OrderVO> getFilterListOf(int id, String state){
		if(!orderPOCache.containsKey(id)){
			loadToCache(id);
		}
		
		List<OrderVO> list = new ArrayList<OrderVO>();
		
		
		for(Entry<Integer, OrderPO> entry: orderPOCache.get(id).entrySet()){
			if(entry.getValue().getOrderState().equals(state)){
				CustomerVO customerVO = BLFactory.getCustomerBLService().getCustomerInfo(entry.getValue().getCustomerID());
				
				OrderVO vo = new OrderVO(entry.getValue().getOrderID(), customerVO.customerName, customerVO.customerID, customerVO.phoneNumber, entry.getValue().getProducingDateTime(), 
						entry.getValue().getHotelName(),  entry.getValue().getRoomName(), entry.getValue().getRoomNum(), entry.getValue().getPeopleNum(), entry.getValue().getHasChildren(), entry.getValue().getCheckInDate(), entry.getValue().getLatestArrivingTime(),
						entry.getValue().getCheckOutDate(), entry.getValue().getTotal(), entry.getValue().getOrderState(),entry.getValue().getHasComment());
				list.add(vo);
			}
		}
		
		return list;
		
	}
	
	private List<OrderVO> getVOListByPOList(Map<Integer, OrderPO> orderPOs) {
		System.out.println("orders");
		List<OrderVO> result = new ArrayList<OrderVO>();
		
		if(orderPOs.size()<1) return result;
		
		for(Entry<Integer, OrderPO> entry: orderPOs.entrySet()){
			CustomerVO customerVO = BLFactory.getCustomerBLService().getCustomerInfo(entry.getValue().getCustomerID());
			
			OrderVO vo = new OrderVO(entry.getValue().getOrderID(), customerVO.customerName, customerVO.customerID, customerVO.phoneNumber, entry.getValue().getProducingDateTime(), 
					entry.getValue().getHotelName(),  entry.getValue().getRoomName(), entry.getValue().getRoomNum(), entry.getValue().getPeopleNum(), entry.getValue().getHasChildren(), entry.getValue().getCheckInDate(), entry.getValue().getLatestArrivingTime(),
					entry.getValue().getCheckOutDate(), entry.getValue().getTotal(), entry.getValue().getOrderState(),entry.getValue().getHasComment());
			result.add(vo);
		}
		
		return result;
	}
	
	private void loadToCache(int userID){
		if(orderPOCache.size() >= maxCache){
			clearSomeCache();
		}
		
		if(userID/100000000 == 1){
			Map<Integer,OrderPO> map = DataFactory.getOrderDataService().getCustomerOrder(userID);
			orderPOCache.put(userID, map);
			IDQueue.add(userID);
			System.out.println("load customer orders");
		}
		else if(userID/100000000 == 2){
			Map<Integer,OrderPO> map = DataFactory.getOrderDataService().getHotelOrder(userID);
			orderPOCache.put(userID, map);
			IDQueue.add(userID);
			System.out.println("load hotel orders");
		}
	}
	
	private void clearSomeCache(){
		for(int i=0; i<10; i++){
			orderPOCache.remove(IDQueue.poll());
		}
	}


	@Override
	public void update(List<OrderPO> changedOrderPO) {
		// TODO Auto-generated method stub
		if(changedOrderPO.size()<1) return ;
		
		for(OrderPO orderPO: changedOrderPO){
			if(orderPOCache.containsKey(orderPO.getCustomerID())){
				orderPOCache.get(orderPO.getCustomerID()).get(orderPO.getOrderID()).setOrderState("异常");
			}
			
			if(orderPOCache.containsKey(orderPO.getHotelID())){
				orderPOCache.get(orderPO.getHotelID()).get(orderPO.getHotelID()).setOrderState("异常");
			}
			
		}
	}
	
}
