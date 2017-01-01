package data.orderdata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;

public class OrderDataService_Stub implements OrderDataService{

	private Map<Integer, OrderPO> map;
	
	public OrderDataService_Stub() {
		// TODO Auto-generated constructor stub
		map = new HashMap<Integer, OrderPO>();
		
		OrderPO orderPO = new OrderPO(900000001, "Stub客户", 100000001, LocalDateTime.of(2016, 10, 10, 8, 3), "Stub酒店", 200000001, "Stub房间", 1, false, 1, LocalDate.of(2016, 10, 10), LocalTime.of(12, 0), LocalDate.of(2016, 10, 11), 150	, "已执行已离店", null, LocalDateTime.of(2016, 10, 10, 10, 0), LocalDateTime.of(2016, 10, 11, 12, 0), false);
		map.put(orderPO.getOrderID(), orderPO);
	}
	
	
	@Override
	public OrderPO getOrderInfo(int orderID) {
		// TODO Auto-generated method stub
		return map.get(900000001);
	}

	@Override
	public Map<Integer, OrderPO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public Map<Integer, OrderPO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public Map<Integer, OrderPO> initAbnormalOrdersOfToday() {
		// TODO Auto-generated method stub
		return new HashMap<>();
	}

	@Override
	public List<OrderPO> getUnhandledAbnormalOrders() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public boolean updateOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		map.replace(100000001, orderPO);
		System.out.println("update order");
		return true;
	}

	@Override
	public boolean insertOrder(OrderPO po) {
		// TODO Auto-generated method stub
		map.put(po.getOrderID(),po);
		return true;
	}

	@Override
	public int getNumOfAllOrders() {
		// TODO Auto-generated method stub
		return map.size();
	}

	@Override
	public List<OrderPO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		List<OrderPO> result = new ArrayList<OrderPO>();
		result.add(map.get(900000001));
		return result;
	}

}
