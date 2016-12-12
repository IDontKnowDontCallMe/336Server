package data.userdata;


import java.util.List;

import dataservice.userdataservice.UserDataService;
import po.CustomerPO;
import po.HotelPO;
import po.WebMarketerPO;

public class UserDataServiceImpl implements UserDataService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public List<CustomerPO> getCustomerList() {
		// TODO Auto-generated method stub
		return userDao.getCustomerList();
	}

	@Override
	public List<HotelPO> getHotelList() {
		// TODO Auto-generated method stub
		return userDao.getHotelList();
	}

	@Override
	public boolean insertWebMarketer(WebMarketerPO po) {
		// TODO Auto-generated method stub
		return userDao.insertWebMarketer(po);
	}

	@Override
	public List<WebMarketerPO> getWebMarketerList() {
		// TODO Auto-generated method stub
		return userDao.getWebMarketerList();
	}

	@Override
	public boolean updateWebMarketer(WebMarketerPO po) {
		// TODO Auto-generated method stub
		return userDao.updateWebMarketer(po);
	}

	@Override
	public String getPassword(int userID) {
		// TODO Auto-generated method stub
		return userDao.getPassword(userID);
	}

	@Override
	public boolean addUser(int userID, String password) {
		// TODO Auto-generated method stub
		return userDao.addUser(userID, password);
	}

	@Override
	public int insertCustomer(CustomerPO customerPO) {
		// TODO Auto-generated method stub
		return userDao.insertCustomer(customerPO);
	}

	
	
	
}
