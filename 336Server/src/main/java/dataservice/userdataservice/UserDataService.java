package dataservice.userdataservice;

import java.util.List;

import po.CustomerPO;
import po.HotelPO;
import po.WebMarketerPO;

public interface UserDataService {

	public List<CustomerPO> getCustomerList();

	public boolean deleteCustomer(int customerID);

	public boolean insertCustomer(CustomerPO po);

	public List<HotelPO> getHotelList();

	public boolean deleteHotel(int hotelID);

	public boolean insertHotel(HotelPO po);

	public boolean insertWebMarketer(WebMarketerPO po);

	public List<WebMarketerPO> getWebMarketerList();

	public boolean deleteWebMarketer(int webMarketerID);
	
	public boolean checkPassword(int userID, String password);

}
