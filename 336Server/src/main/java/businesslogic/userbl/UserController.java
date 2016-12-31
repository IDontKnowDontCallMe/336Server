package businesslogic.userbl;

import java.util.List;

import businesslogicservice.userblservice.UserBLService;
import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;

public class UserController implements UserBLService{
	
	private UserBLImpl userBLImpl;
	
	public UserController() {
		// TODO Auto-generated constructor stub
		userBLImpl = new UserBLImpl();
	}
	
	public List<CustomerVO> getCustomerList() {
		return userBLImpl.getCustomerList();
	}
	
	public boolean updateCustomer(CustomerVO customerVO) {
		return userBLImpl.updateCustomer(customerVO);
	}
	
	@Override
	public boolean addCustomer(CustomerVO customervo) {
		return false;
		//需求无，暂时不实现了
	}
	
	public List<HotelVO> getHotelList() {
		return userBLImpl.getHotelList();
	}
	
	public boolean addHotel(HotelVO hotelVO) {
		return userBLImpl.addHotel(hotelVO);
	}
	
	public boolean updateHotelWorker(HotelVO hotelVO) {
		return userBLImpl.updateHotelWorker(hotelVO);
	}
		
	public List<WebMarketerVO> getWebMarketerList() {
		return userBLImpl.getWebMarketerList();
	}
	
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) {
		return userBLImpl.addWebMarketer(webMarketerVO);
	}
	
	public boolean updateWebMarketer(WebMarketerVO webMarketerVO) {
		return userBLImpl.updateWebMarketer(webMarketerVO);
	}
	
	public String login(int userID, String password) {
		return userBLImpl.login(userID, password);
	}

	public WebMarketerVO getWebMarketerInfo(int WebMarketerID) {
		return null;
		//需求没有相关要求，具体不实现了（相关需求可通过getWebMarList完成）;
	}

	@Override
	public boolean updateCreditOfCustomer(int customerID, int delta) {
		return userBLImpl.updateCreditOfCustomer(customerID, delta);
	}

	@Override
	public int register(String customerName, String phoneNumber, String password) {
		// TODO Auto-generated method stub
		return userBLImpl.register(customerName, phoneNumber, password);
	}

	@Override
	public void survivalConfirm(int userID) {
		// TODO Auto-generated method stub
		userBLImpl.survivalConfirm(userID);
	}

	@Override
	public void changePassword(int userID, String newPassword) {
		// TODO Auto-generated method stub
		userBLImpl.changePassword(userID, newPassword);
	}

	
}
