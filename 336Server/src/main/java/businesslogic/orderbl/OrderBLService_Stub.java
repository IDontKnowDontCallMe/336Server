package businesslogic.orderbl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.orderblservice.OrderBLService;
import javafx.geometry.VPos;
import vo.CalculationConditionVO;
import vo.OrderVO;

public class OrderBLService_Stub implements OrderBLService{

	private List<OrderVO> list;
	
	public OrderBLService_Stub() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<OrderVO>();
		OrderVO orderVO = new OrderVO(900000001, "Stub客户", 100000001, "1380000000", LocalDateTime.of(2016, 10, 10, 8, 2), "Stub酒店", "Stub房间", 1, 1, false, LocalDate.of(2016, 10, 10), LocalTime.of(12, 0), LocalDate.of(2016, 10, 11), 150, "已执行已离店", false);
		list.add(orderVO);
	}
	
	@Override
	public List<OrderVO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<OrderVO> getAbnormalOrdersOfToday() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public List<OrderVO> filterCustomerList(int customerID, String state) {
		// TODO Auto-generated method stub
		System.out.println("filter customer orders");
		return list;
	}

	@Override
	public List<OrderVO> filterHotelList(int hotelID, String state) {
		// TODO Auto-generated method stub
		System.out.println("filter hotel orders");
		return list;
	}

	@Override
	public int calculateTotal(CalculationConditionVO vo) {
		// TODO Auto-generated method stub
		return vo.roomPrice;
	}

	@Override
	public String canBeProduced(CalculationConditionVO vo) {
		// TODO Auto-generated method stub
		return "房间充足";
	}

	@Override
	public boolean produceOrder(OrderVO orderVO, CalculationConditionVO calculationConditionVO) {
		// TODO Auto-generated method stub
		System.out.println("produce order");
		return true;
	}

	@Override
	public boolean changeOrderState(int orderID, String state) {
		// TODO Auto-generated method stub
		System.out.println("change order state");
		return true;
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Integer> getBookedHotelidOf(int customerID) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<>();
		result.add(200000001);
		return result;
	}

	@Override
	public int getBookedTag(int customerID, int hotelID) {
		// TODO Auto-generated method stub
		return 2;
	}

}
