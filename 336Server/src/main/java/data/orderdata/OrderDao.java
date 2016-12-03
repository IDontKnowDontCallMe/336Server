package data.orderdata;

import java.util.List;

import po.OrderPO;

public interface OrderDao {
	
	public OrderPO getOrderByOrderID(int orderID);
	
	public List<OrderPO> getOrderByCustomerID(int customerID);
	
	public List<OrderPO> getOrderByHotelID(int hotelID);
	
	public List<OrderPO> getAbnormalOrdersOfToday();
	
	public boolean updateOrder(OrderPO orderPO);
	
	public boolean insertOrder(OrderPO po);
	
	public int getNumOfAllOrders();

	public List<OrderPO> getOrderListByHotelID_CustomerID(int hotelID, int customerID) ;

}
