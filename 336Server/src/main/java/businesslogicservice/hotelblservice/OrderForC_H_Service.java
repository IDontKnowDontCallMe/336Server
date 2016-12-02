package businesslogicservice.hotelblservice;

import java.util.List;

import vo.OrderVO;

//为了消除循环依赖设定的接口
public interface OrderForC_H_Service {

	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID);
	
	public int getBookedTag(int customerID, int hotelID);
	
}
