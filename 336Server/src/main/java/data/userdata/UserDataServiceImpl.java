package data.userdata;

import java.util.List;

import dataservice.userdataservice.UserDataService;
import po.CustomerPO;
import po.HotelPO;
import po.WebMarketerPO;

public class UserDataServiceImpl implements UserDataService{
	
	private CustomerDao customerDao;
	private HotelDao hotelDao;
	private WebMarketerDao marketerDao;
	
	public UserDataServiceImpl() {
		// TODO Auto-generated constructor stub
		customerDao = UserDaoFactory.getCustomerDao();
		hotelDao = UserDaoFactory.getHotelDao();
		marketerDao = UserDaoFactory.getMarketerDao();
	}

	@Override
	public List<CustomerPO> getCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomer(int customerID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertCustomer(CustomerPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HotelPO> getHotelList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteHotel(int hotelID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertHotel(HotelPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertWebMarketer(WebMarketerPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WebMarketerPO> getWebMarketerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteWebMarketer(int webMarketerID) {
		// TODO Auto-generated method stub
		return false;
	}

}
