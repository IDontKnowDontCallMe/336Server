package businesslogic.orderbl;

import java.util.List;

import businesslogicservice.orderblservice.OrderBLService;
import vo.CalculationConditionVO;
import vo.OrderVO;

public class OrderController implements OrderBLService{

	private OrderBLImpl orderBLImpl;
	
	public OrderController() {
		// TODO Auto-generated constructor stub
		orderBLImpl = new OrderBLImpl();
	}
	
	@Override
	public List<OrderVO> getCustomerOrder(int customerID){
		// TODO Auto-generated method stub
		return orderBLImpl.getCustomerOrder(customerID);
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID){
		// TODO Auto-generated method stub
		return orderBLImpl.getHotelOrder(hotelID);
	}

	@Override
	public List<OrderVO> getAbnormalOrdersOfToday(){
		// TODO Auto-generated method stub
		return orderBLImpl.getAbnormalOrdersOfToday();
	}

	@Override
	public List<OrderVO> filterCustomerList(int customerID, String state) {
		// TODO Auto-generated method stub
		return orderBLImpl.filterCustomerList(customerID, state);
	}

	@Override
	public List<OrderVO> filterHotelList(int hotelID, String state) {
		// TODO Auto-generated method stub
		return orderBLImpl.filterHotelList(hotelID, state);
	}

	

	@Override
	public int calculateTotal(CalculationConditionVO vo) {
		// TODO Auto-generated method stub
		return orderBLImpl.calculateTotal(vo);
	}

	@Override
	public boolean produceOrder(OrderVO orderVO , CalculationConditionVO calculationConditionVO) {
		// TODO Auto-generated method stub
		return orderBLImpl.produceOrder(orderVO, calculationConditionVO);
	}

	@Override
	public boolean changeOrderState(int orderID, String state) {
		// TODO Auto-generated method stub
		return orderBLImpl.changeOrderState(orderID, state);
	}

	@Override
	public String canBeProduced(CalculationConditionVO vo) {
		// TODO Auto-generated method stub
		return orderBLImpl.canBeProduced(vo);
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		return orderBLImpl.getOrderListOfHotel(hotelID, customerID);
	}

	@Override
	public int getBookedTag(int customerID, int hotelID) {
		// TODO Auto-generated method stub
		//此方法能够用于hotel模块，搜索功能时，确定该customer是否预订过该hotel
		return orderBLImpl.getBookedTag(customerID, hotelID);
	}

	@Override
	public List<Integer> getBookedHotelidOf(int customerID) {
		// TODO Auto-generated method stub
		//此方法用于hotel模块，customer查看自己预定过的酒店时
		return orderBLImpl.getBookedHotelidOf(customerID);
	}

	
	
	
	

}
