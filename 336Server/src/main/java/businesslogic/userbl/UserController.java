package businesslogic.userbl;

import java.util.List;

import businesslogicservice.userblservice.UserBLService;
import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;

public class UserController implements UserBLService{
	public List<CustomerVO> getCustomerList() {
		return null;
		}
	
	public boolean updateCustomer(CustomerVO customerVO) {
		return false;
	}
	
	@Override
	public boolean addCustomer(CustomerVO customervo) {
		return false;
	}
	
		public List<HotelVO> getHotelList() {
		return null;
	}
	
	public boolean addHotel(HotelVO hotelVO) {
		return false;
	}
	
	public boolean updateHotelWorker(HotelVO hotelVO) {
		return false;
	}
		
	public List<WebMarketerVO> getWebMarketerList() {
		return null;
	}
	
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) {
		return false;
	}
	
	public boolean updateWebMarketer(WebMarketerVO webMarketerVO) {
		return false;
	}
	
	public String login(int userID, String password) {
		return null;
	}

	public WebMarketerVO getWebMarketerInfo(int WebMarketerID) {
		return null;
	}

	@Override
	public boolean updateCreditOfCustomer(int customerID, int delta) {
		return false;
	}

	
}
