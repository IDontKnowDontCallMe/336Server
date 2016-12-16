package businesslogic.orderbl;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.orderblservice.OrderBLService;
import vo.CalculationConditionVO;
import vo.OrderVO;

public class OrderBLMock implements OrderBLService{
	
	public OrderBLMock() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OrderVO> getCustomerOrder(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getAbnormalOrdersOfToday() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> filterCustomerList(int customerID, String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> filterHotelList(int hotelID, String state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculateTotal(CalculationConditionVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String canBeProduced(CalculationConditionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean produceOrder(OrderVO orderVO, CalculationConditionVO calculationConditionVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeOrderState(int orderID, String state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getBookedHotelidOf(int customerID) {
		// TODO Auto-generated method stub
		if(customerID==100000001){
			List<Integer> list = new ArrayList<Integer>();
			list.add(200000001);
			list.add(200000002);
			return list;
		}
		
		return new ArrayList<Integer>();
	}

	@Override
	public int getBookedTag(int customerID, int hotelID) {
		// TODO Auto-generated method stub
		if(customerID==100000001 && hotelID==200000001){
			return 2;
		}
		
		if(customerID==100000001 && hotelID==200000002){
			return 1;
		}
		return 0;
	}

}
