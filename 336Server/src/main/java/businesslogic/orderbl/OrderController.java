package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.orderblservice.OrderBLService;
import vo.CalculationConditionVO;
import vo.OrderVO;

public class OrderController implements OrderBLService{

	private OrderBLImpl orderBLImpl;
	
	@Override
	public List<OrderVO> getCustomerOrder(int customerID){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getHotelOrder(int hotelID){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getAbnormalOrdersOfToday(){
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
	public boolean produceOrder(OrderVO orderVO , CalculationConditionVO calculationConditionVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeOrderState(int orderID, String state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String canBeProduced(CalculationConditionVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBookedTag(int customerID, int hotelID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getBookedHotelidOf(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
