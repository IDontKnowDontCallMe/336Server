package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import javax.naming.spi.DirStateFactory.Result;

import factory.BLFactory;
import data.factory.DataFactory;
import po.HotelPO;
import po.OrderPO;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.OrderVO;

public class OrderBLImpl {

	private HashMap<Integer, List<OrderPO>> orderPOCache;
	private Queue<Integer> IDQueue;
	private static final int maxCache = 220;
	
	public OrderBLImpl() {
		// TODO Auto-generated constructor stub
		orderPOCache = new HashMap<>();
		IDQueue = new ArrayDeque<Integer>();
	}
	
	
	public List<OrderVO> getCustomerOrder(int customerID) {

		return getOrderListOf(customerID);
	}
	

	public List<OrderVO> getHotelOrder(int hotelID){
		
		return getOrderListOf(hotelID);
	}

	public List<OrderVO> getAbnormalOrdersOfToday(){
		List<OrderPO> abnormalList = DataFactory.getOrderDataService().getAbnormalOrdersOfToday();
		
		return getVOListByPOList(abnormalList);
	}
	

	public List<OrderVO> filterCustomerList(int customerID, String state) {

		return getFilterListOf(customerID, state);
	}

	public List<OrderVO> filterHotelList(int hotelID, String state) {

		return getFilterListOf(hotelID, state);
	}
	
	public String canBeProduced(CalculationConditionVO calculationConditionVO) {

		if(!orderPOCache.containsKey(calculationConditionVO.customerID)){
			loadToCache(calculationConditionVO.customerID);
		}
		
		ValidOrderJudger judger = new ValidOrderJudger(calculationConditionVO, orderPOCache.get(calculationConditionVO.customerID));
		
		return judger.judge();
	}
	
	public int calculateTotal(CalculationConditionVO vo) {

		CustomerVO customerVO = BLFactory.getCustomerBLService().getCustomerInfo(vo.customerID);
		
		int total = -1;
		
		try {
			total = BLFactory.getPromotionBLService().calculateOrder(vo, customerVO);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
	}
	

	public boolean produceOrder(OrderVO orderVO, CalculationConditionVO calculationConditionVO) throws RemoteException {

		int orderID = orderVO.orderID == -1? DataFactory.getOrderDataService().getNumOfAllOrders()+1+900000000 : orderVO.orderID;
		
		CustomerVO customerVO = BLFactory.getCustomerBLService().getCustomerInfo(orderVO.customerID);
		
		OrderPO orderPO = new OrderPO(orderID, customerVO.customerName, customerVO.customerID, LocalDateTime.now(), orderVO.hotelName, 
									calculationConditionVO.hotelID, orderVO.roomName, calculationConditionVO.roomNum, orderVO.hasChildren, 
				orderVO.peopleNum, orderVO.checkInTime, orderVO.lastestArrivingTime, orderVO.checkOutTime, orderVO.total, "正常", null, null, null,false);
		
		DataFactory.getOrderDataService().insertOrder(orderPO);
		
		if(orderPOCache.containsKey(orderVO.customerID)){
			orderPOCache.get(orderVO.customerID).add(orderPO);
		}
		
		return true;
	}
	

	public boolean changeOrderState(int orderID, String state) throws RemoteException {
		
		OrderChanger orderChanger = new OrderChanger(orderID, state);
		
		OrderPO po = orderChanger.change();
		
		if(po!=null){
			List<OrderPO> list = null;
			if(orderPOCache.containsKey(po.getCustomerID()) ){
				list = orderPOCache.get(po.getCustomerID());
			}
			else if(orderPOCache.containsKey(po.getHotelID())){
				list = orderPOCache.get(po.getHotelID());
			}
			
			if(list!=null){
				for(OrderPO orderPO: list){
					if(orderPO.getOrderID()==po.getOrderID()){
						orderPO.setOrderState(po.getOrderState());
						break;
					}
				}
			}
		}
		
		return true;
	}
	
	
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		
		if(!orderPOCache.containsKey(customerID)){
			loadToCache(customerID);
		}

		List<OrderPO> list = new ArrayList<OrderPO>();
		
		for(OrderPO po: orderPOCache.get(customerID)){
			if(po.getHotelID() == hotelID){
				list.add(po);
			}
		}
		
		List<OrderVO> result = getVOListByPOList(list);
		
		return result;
	}

	
	public int getBookedTag(int customerID, int hotelID) {
		if(!orderPOCache.containsKey(customerID)){
			loadToCache(customerID);
		}
		
		List<OrderPO> list = orderPOCache.get(customerID);
		
		int result = 0;
		
		for(OrderPO po: list){
			if(po.getHotelID() != hotelID){
				continue;
			}
			else if(po.getOrderState().equals("已执行")) {
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
		
		List<OrderPO> orderList = orderPOCache.get(customerID);
		
		for(OrderPO po: orderList){
			result.add(po.getHotelID());
		}
		
		return result;
	}
	
	
	
	//-------------------------------------------------------------------
	
	private List<OrderVO> getOrderListOf(int id){
		if(!orderPOCache.containsKey(id)){
			loadToCache(id);
		}
		
		return getVOListByPOList(orderPOCache.get(id));
	}
	
	private List<OrderVO> getFilterListOf(int id, String state){
		if(!orderPOCache.containsKey(id)){
			loadToCache(id);
		}
		
		List<OrderVO> list = getVOListByPOList(orderPOCache.get(id));
		Iterator<OrderVO> iterator = list.iterator();
		
		while(iterator.hasNext()){
			OrderVO vo = iterator.next();
			if(!vo.equals(state)){
				iterator.remove();
			}
		}
		
		return list;
		
	}
	
	private List<OrderVO> getVOListByPOList(List<OrderPO> orderPOs){
		List<OrderVO> result = new ArrayList<OrderVO>();
		for(OrderPO po: orderPOs){
			CustomerVO customerVO = BLFactory.getCustomerBLService().getCustomerInfo(po.getCustomerID());
			
			OrderVO vo = new OrderVO(po.getOrderID(), customerVO.customerName, customerVO.customerID, customerVO.phoneNumber, po.getProducingDateTime(), 
									po.getHotelName(),  po.getRoomName(), po.getRoomNum(), po.getPeopleNum(), po.getHasChildren(), po.getCheckInDate(), po.getLatestArrivingTime(),
									po.getCheckOutDate(), po.getTotal(), po.getOrderState(),po.getHasComment());
			result.add(vo);
		}
		return result;
	}
	
	private void loadToCache(int userID){
		if(orderPOCache.size() >= maxCache){
			clearSomeCache();
		}
		
		if(userID/100000000 == 1){
			List<OrderPO> list = DataFactory.getOrderDataService().getCustomerOrder(userID);
			orderPOCache.put(userID, list);
			IDQueue.add(userID);
		}
		else if(userID/100000000 == 2){
			List<OrderPO> list = DataFactory.getOrderDataService().getHotelOrder(userID);
			orderPOCache.put(userID, list);
			IDQueue.add(userID);
		}
	}
	
	private void clearSomeCache(){
		for(int i=0; i<10; i++){
			orderPOCache.remove(IDQueue.poll());
		}
	}
	
}
