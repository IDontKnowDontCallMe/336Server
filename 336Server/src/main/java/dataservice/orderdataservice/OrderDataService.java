package dataservice.orderdataservice;

import java.util.List;
import java.util.Map;

import po.OrderPO;

/**
 * OrderData模块的接口
 * @author sjl
 *
 */
/**
 * @author USER
 *
 */
/**
 * @author USER
 *
 */
public interface OrderDataService {
	
	/**
	 * @param orderID 
	 * @return 对应该某订单编号的一条订单记录
	 */
	public OrderPO getOrderInfo(int orderID);
	
	/**
	 * 获得一个客户的所有订单的记录
	 * @param customerID
	 * @return 一个包含符合条件的订单记录的map，key值是订单编号
	 */ 
	public Map<Integer, OrderPO> getCustomerOrder(int customerID);
	
	/**
	 * 获得一个酒店的所有订单记录
	 * @param hotelID
	 * @return 一个包含符合条件的订单记录的map，key值是订单编号
	 */
	public Map<Integer,OrderPO> getHotelOrder(int hotelID);
	
	/**
	 * 更新订单表中的所有记录，将超时未入住的订单设为异常，并返回今日的异常订单列表
	 * @return 今日的异常订单，key为订单编号
	 */
	public Map<Integer,OrderPO> initAbnormalOrdersOfToday();
	
	/**
	 * 查询unhandle_abnormal_order表，并返回所有该表中的orderID的订单，之后清空该表
	 * @return 表中订单编号的订单列表
	 */
	public List<OrderPO> getUnhandledAbnormalOrders();
	
	/**
	 * 更新一条订单记录
	 * @param orderPO
	 * @return 更新成功返回投入而，否则false
	 */
	public boolean updateOrder(OrderPO orderPO);
	
	/**
	 * 添加一条订单记录
	 * @param OrderPO
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean insertOrder(OrderPO po);
	
	/**
	 * @return 订单表的记录的数量
	 */
	public int getNumOfAllOrders();
	
	
	/**
	 * @param hotelID
	 * @param customerID
	 * @return 包含所有hotelID、customerID字段的值为参数的订单记录的列表
	 */
	public List<OrderPO> getOrderListOfHotel(int hotelID, int customerID) ;

}
