package data.userdata;

import java.util.List;

import po.CustomerPO;
import po.HotelPO;
import po.WebMarketerPO;

public interface UserDao {

	public List<CustomerPO> getCustomerList();

	public List<HotelPO> getHotelList();

	public boolean insertWebMarketer(WebMarketerPO po);

	public List<WebMarketerPO> getWebMarketerList();
	
	public boolean updateWebMarketer(WebMarketerPO po);
	
	public String getPassword(int userID);
	
	public boolean addUser(int userID, String password);
	
}
