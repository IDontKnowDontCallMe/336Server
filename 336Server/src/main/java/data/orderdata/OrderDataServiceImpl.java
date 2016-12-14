package data.orderdata;

import java.util.List;
import java.util.Map;

import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;

public class OrderDataServiceImpl implements OrderDataService{
	
	private OrderDao orderDao ;
	
	public OrderDataServiceImpl() {
		// TODO Auto-generated constructor stub
		orderDao = OrderDaoFactory.getOrderDaoInstance();
	}

	@Override
	public OrderPO getOrderInfo(int orderID) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByOrderID(orderID);
	}

	@Override
	public Map<Integer,OrderPO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByCustomerID(customerID);
	}

	@Override
	public Map<Integer,OrderPO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return orderDao.getOrderByHotelID(hotelID);
	}


	@Override
	public boolean updateOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return orderDao.updateOrder(orderPO);
	}

	@Override
	public boolean insertOrder(OrderPO po) {
		// TODO Auto-generated method stub
		return orderDao.insertOrder(po);
	}

	@Override
	public int getNumOfAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.getNumOfAllOrders();
	}

	@Override
	public List<OrderPO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		return orderDao.getOrderListByHotelID_CustomerID(hotelID, customerID);
	}

	@Override
	public Map<Integer, OrderPO> initAbnormalOrdersOfToday() {
		// TODO Auto-generated method stub
		return orderDao.initAbnormalOrdersOfToday();
	}

	@Override
	public List<OrderPO> getUnhandledAbnormalOrders() {
		// TODO Auto-generated method stub
		return orderDao.getUnhandledAbnormalOrders();
	}

	
	
	
	


	

}
