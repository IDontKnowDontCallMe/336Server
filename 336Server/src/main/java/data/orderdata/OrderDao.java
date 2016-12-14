package data.orderdata;

import java.util.List;
import java.util.Map;

import po.OrderPO;

public interface OrderDao {
	
	public OrderPO getOrderByOrderID(int orderID);
	
	public Map<Integer,OrderPO> getOrderByCustomerID(int customerID);
	
	public Map<Integer,OrderPO> getOrderByHotelID(int hotelID);
	
	public boolean updateOrder(OrderPO orderPO);
	
	public boolean insertOrder(OrderPO po);
	
	public int getNumOfAllOrders();

	public List<OrderPO> getOrderListByHotelID_CustomerID(int hotelID, int customerID) ;
	
	public Map<Integer,OrderPO> initAbnormalOrdersOfToday();
	
	public List<OrderPO> getUnhandledAbnormalOrders();
	
	

}
