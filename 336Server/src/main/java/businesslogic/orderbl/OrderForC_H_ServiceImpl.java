package businesslogic.orderbl;

import java.util.List;

import businesslogicservice.hotelblservice.OrderForC_H_Service;
import vo.OrderVO;

public class OrderForC_H_ServiceImpl implements OrderForC_H_Service{

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

}
