package businesslogicservice.userblservice;


import java.util.List;

import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;

public interface UserBLService {

	public List<CustomerVO> getCustomerList() ;
	
	public boolean addCustomer(CustomerVO customervo);
	
	public boolean updateCustomer(CustomerVO customerVO) ;
	
	public List<HotelVO> getHotelList() ;
	
	public boolean addHotel(HotelVO hotelVO) ;
	
	public boolean updateHotelWorker(HotelVO hotelVO) ;
	
	public List<WebMarketerVO> getWebMarketerList();
	
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) ;
	
	public boolean updateCreditOfCustomer(int customerID, int delta);
	
	public String login(int userID, String password) ;
	
	public void survivalConfirm(int userID);
	
	public int register(String customerName, String phoneNumber, String password) ;

	public boolean updateWebMarketer(WebMarketerVO vo) ;

	
}
