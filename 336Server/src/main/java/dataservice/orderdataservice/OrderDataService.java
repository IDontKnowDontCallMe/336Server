package dataservice.orderdataservice;

import java.util.List;
import java.util.Map;

import po.OrderPO;

public interface OrderDataService {
	
	public OrderPO getOrderInfo(int orderID);
	
	public Map<Integer, OrderPO> getCustomerOrder(int customerID);
	
	public Map<Integer,OrderPO> getHotelOrder(int hotelID);
	
	public List<OrderPO> getAbnormalOrdersOfToday();
	
	//public void changeOrderState(String orderID, String state);
	
	public boolean updateOrder(OrderPO orderPO);
	
	public boolean insertOrder(OrderPO po);
	
	public int getNumOfAllOrders();
	
	//2016/12/2 22:27 +
	public List<OrderPO> getOrderListOfHotel(int hotelID, int customerID) ;

}
