package businesslogic.userbl;

import java.awt.TexturePaint;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.userblservice.UserBLService;
import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;

public class UserBLService_Stub implements UserBLService{
	
	private List<CustomerVO> customerList;
	private List<HotelVO> hotelList;
	private List<WebMarketerVO> webMarketerList;
	
	
	public UserBLService_Stub() {
		// TODO Auto-generated constructor stub
		customerList = new ArrayList<CustomerVO>();
		CustomerVO customerVO = new CustomerVO(100000001, "Stub客户", "13800001111", true, LocalDate.of(1996, 7, 29), false, null, 500, 0);
		customerList.add(customerVO);
		
		hotelList = new ArrayList<>();
		HotelVO hotelVO = new HotelVO(200000001, "Stub酒店", "南京", "栖霞区", "仙林大道", "Stub之用", "Stub服务", 5, 5, "Stub工作人员", "15800002222", 150, 2);
		hotelList.add(hotelVO);
		
		webMarketerList = new ArrayList<>();
		WebMarketerVO webMarketerVO = new WebMarketerVO(400000001, "Stub网站营销人员", "15800004444");
		webMarketerList.add(webMarketerVO);
	}

	@Override
	public List<CustomerVO> getCustomerList() {
		// TODO Auto-generated method stub
		return customerList;
	}

	@Override
	public boolean addCustomer(CustomerVO customervo) {
		// TODO Auto-generated method stub
		System.out.println("add customer");
		return true;
	}

	@Override
	public boolean updateCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		System.out.println("update customer");
		return true;
	}

	@Override
	public List<HotelVO> getHotelList() {
		// TODO Auto-generated method stub
		return hotelList;
	}

	@Override
	public boolean addHotel(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		System.out.println("add hotel");
		return true;
	}

	@Override
	public boolean updateHotelWorker(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		System.out.println("update hotel worker");
		return true;
	}

	@Override
	public List<WebMarketerVO> getWebMarketerList() {
		// TODO Auto-generated method stub
		return webMarketerList;
	}

	@Override
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) {
		// TODO Auto-generated method stub
		System.out.println("add web marketer");
		return true;
	}

	@Override
	public boolean updateCreditOfCustomer(int customerID, int delta) {
		// TODO Auto-generated method stub
		System.out.println("update credit");
		return true;
	}

	@Override
	public String login(int userID, String password) {
		// TODO Auto-generated method stub
		System.out.println("login");
		return "customer";
	}

	@Override
	public void survivalConfirm(int userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int register(String customerName, String phoneNumber, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void changePassword(int userID, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateWebMarketer(WebMarketerVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
