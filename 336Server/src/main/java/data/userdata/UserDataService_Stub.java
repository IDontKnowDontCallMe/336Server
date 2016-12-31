package data.userdata;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dataservice.userdataservice.UserDataService;
import po.CustomerPO;
import po.HotelPO;
import po.WebMarketerPO;

public class UserDataService_Stub implements UserDataService{

	private List<CustomerPO> customerList;
	private List<HotelPO> hotelList;
	private List<WebMarketerPO> webMarketerList;
	
	public UserDataService_Stub() {
		// TODO Auto-generated constructor stub
		customerList = new ArrayList<CustomerPO>();
		hotelList = new ArrayList<>();
		webMarketerList = new ArrayList<>();
		
		CustomerPO  customerPO = new CustomerPO("Stub客户", "13800001234", 100000001, LocalDate.of(1996, 7, 29), null, 500, true, false);
		HotelPO hotelPO = new HotelPO(200000001, "Stub酒店", "南京", "栖霞区", "仙林大道", "只是一个stub", "无服务", "苏先生", "15800001111", 5, 5, -1, -1);
		WebMarketerPO webMarketerPO = new WebMarketerPO(400000001, "Stub网站营销人员", "15833334444");
		
		customerList.add(customerPO);
		hotelList.add(hotelPO);
		webMarketerList.add(webMarketerPO);
	}
	
	@Override
	public List<CustomerPO> getCustomerList() {
		// TODO Auto-generated method stub
		return customerList;
	}

	@Override
	public List<HotelPO> getHotelList() {
		// TODO Auto-generated method stub
		return hotelList;
	}

	@Override
	public boolean insertWebMarketer(WebMarketerPO po) {
		// TODO Auto-generated method stub
		webMarketerList.add(po);
		return true;
	}

	@Override
	public List<WebMarketerPO> getWebMarketerList() {
		// TODO Auto-generated method stub
		return webMarketerList;
	}

	@Override
	public boolean updateWebMarketer(WebMarketerPO po) {
		// TODO Auto-generated method stub
		System.out.println("update webMarketer");
		return true;
	}

	@Override
	public String getPassword(int userID) {
		// TODO Auto-generated method stub
		return "Stub password";
	}

	@Override
	public boolean addUser(int userID, String password) {
		// TODO Auto-generated method stub
		System.out.println("add User");
		return true;
	}

	@Override
	public void updatePassworder(int userID, String newPassword) {
		// TODO Auto-generated method stub
		System.out.println("update password");
	}

	@Override
	public int insertCustomer(CustomerPO customerPO) {
		// TODO Auto-generated method stub
		return customerPO.getID();
	}

}
