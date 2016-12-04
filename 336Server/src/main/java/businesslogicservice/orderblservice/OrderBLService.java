package businesslogicservice.orderblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import po.OrderPO;
import vo.CalculationConditionVO;
import vo.OrderVO;

/**
 * 
 * @author USER
 *
 */
public interface OrderBLService{
	
	public List<OrderVO> getCustomerOrder(int customerID);
	
	public List<OrderVO> getHotelOrder(int hotelID);
	
	public List<OrderVO> getAbnormalOrdersOfToday() ;
	
	public List<OrderVO> filterCustomerList(int customerID, String state) ;
	
	public List<OrderVO> filterHotelList(int hotelID, String state) ;

	//public int calculateTotal() throws RemoteException;
	
	public int calculateTotal(CalculationConditionVO vo) ;
	
	public String canBeProduced(CalculationConditionVO vo) ;
	
	public boolean produceOrder(OrderVO orderVO, CalculationConditionVO calculationConditionVO) ;
	
	public boolean changeOrderState(int orderID, String state) ;
	
	//-------------
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) ;
	
	public List<Integer> getBookedHotelidOf(int customerID);
	
	public int getBookedTag(int customerID, int hotelID) ;
	
}
