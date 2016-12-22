package businesslogicservice.orderblservice;


import java.util.List;
import vo.CalculationConditionVO;
import vo.OrderVO;

/**
 * OrderBL模块提供的接口
 * @author sjl
 *
 */
public interface OrderBLService{
	
	/**
	 * 获得客户的订单列表
	 * @param customerID
	 * @return 客户的订单列表
	 */
	public List<OrderVO> getCustomerOrder(int customerID);
	
	/**
	 * 获得酒店的订单列表
	 * @param hotelID
	 * @return 酒店的订单列表
	 */
	public List<OrderVO> getHotelOrder(int hotelID);
	
	/**
	 * 获得今日异常订单列表
	 * @return 今日异常订单列表
	 */
	public List<OrderVO> getAbnormalOrdersOfToday();
	
	/**
	 * 获得客户的某种状态的订单
	 * @param customerID
	 * @param state 有：“已执行未离店”、“已执行已离店”、“正常”、“已撤销”、“异常”
	 * @return 客户的某种状态的订单
	 */
	public List<OrderVO> filterCustomerList(int customerID, String state) ;
	
	/**
	 * 获得酒店的某种状态的订单
	 * @param hotelID
	 * @param state 有：“已执行未离店”、“已执行已离店”、“正常”、“已撤销”、“异常”
	 * @return 酒店的某种状态的订单
	 */
	public List<OrderVO> filterHotelList(int hotelID, String state) ;
	
	/**
	 * 计算并返回一定计算条件下的订单的总价，是各种促销优惠后的最低价
	 * @param calculationConditionVO 包含订单执行日期、离店日期、房型、放假数量、客户ID等
	 * @return 计算后的最低总价
	 */
	public int calculateTotal(CalculationConditionVO vo) ;
	
	/**
	 * 判断该订单是否可以生成，符合生成订单的条件
	 * @param calculationConditionVO 包含订单执行日期、离店日期、房型、放假数量、客户ID等
	 * @return 可以生成返回true，否则false
	 */
	public String canBeProduced(CalculationConditionVO vo) ;
	
	/**
	 * 生成订单
	 * @param orderVO
	 * @param calculationConditionVO
	 * @return 生成成功返回true，否则false
	 */
	public boolean produceOrder(OrderVO orderVO, CalculationConditionVO calculationConditionVO) ;
	
	/**
	 * 改变订单的状态
	 * @param orderID
	 * @param state 将改变成的状态，有：“已执行未离店”、“已执行已离店”、“正常”、“已撤销”、“异常”
	 * @return 改变成功返回true，否则false
	 */
	public boolean changeOrderState(int orderID, String state) ;

	/**
	 * 获得客户预定过的该酒店的订单
	 * @param hotelID
	 * @param customerID
	 * @return 客户预定过的该酒店的订单
	 */
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) ;
	
	/**
	 * 获得客户预定过的酒店ID的列表
	 * @param customerID
	 * @return 客户预定过的酒店ID的列表
	 */
	public List<Integer> getBookedHotelidOf(int customerID);
	
	/**
	 * 获得某客户对于某酒店的预订情况
	 * @param customerID
	 * @param hotelID
	 * @return 0：未预定过；1：预定过但未成功入住；2：入住过
	 */
	public int getBookedTag(int customerID, int hotelID) ;
	
}
