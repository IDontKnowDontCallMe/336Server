package businesslogic.userbl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import businesslogicservice.userblservice.UserBLService;
import factory.BLFactory;
import factory.DataFactory;
import po.CustomerPO;
import po.HotelPO;
import po.WebMarketerPO;
import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;

public class UserBLImpl implements UserBLService {

	private Map<Integer, Boolean> loginTag;
	
	public UserBLImpl() {
		// TODO Auto-generated constructor stub
		loginTag = new HashMap<Integer, Boolean>();
	}
	
	
	
	@Override
	public List<CustomerVO> getCustomerList() {
		List<CustomerVO> result = new ArrayList<CustomerVO>();
		List<CustomerPO> customerList = DataFactory.getUserDataService().getCustomerList();
		for (CustomerPO po : customerList) {
			int level = BLFactory.getPromotionBLService().calculateLevel(po.getCredit());
			CustomerVO vo = new CustomerVO(po.getID(), po.getName(), po.getPhoneNumber(), po.isBirthVIP(),
					po.getVIPbirthday(), po.isCompanyVIP(), po.getVIPcompany(), po.getCredit(), level);
			result.add(vo);
		}
		return result;
	}

	@Override
	public boolean updateCustomer(CustomerVO vo) {
		CustomerInfoUpdater customerInfoUpdater = BLFactory.getCustomerInfoUpdater();
		
		return customerInfoUpdater.updateSimpleCustomerInfo(vo);
	}

	@Override
	public boolean addCustomer(CustomerVO vo) {
		//需求无此方法暂时不实现了
		return false;
	}
	
	@Override
	public List<HotelVO> getHotelList() {
		List<HotelVO> result = new ArrayList<HotelVO>();
		List<HotelPO> hotelList = DataFactory.getUserDataService().getHotelList();
		for (HotelPO po : hotelList) {
			HotelVO vo = new HotelVO(po.getHotelID(), po.getHotelName(), po.getCity(), po.getBusinessCircle(),
					po.getAddress(), po.getIntroduction(), po.getService(), po.getScore(), po.getCommentScore(),
					po.getWorkerName(), po.getPhoneNumber(), po.getMinPrice(), po.getBookedTag());
			result.add(vo);
		}
		return result;
	}

	@Override
	public boolean addHotel(HotelVO vo) {
		HotelInfoUpdater hotelInfoUpdater = BLFactory.getHotelInfoUpdater();
		int hotelID = DataFactory.getUserDataService().getHotelList().size() + 200000001;
		vo.hotelID = hotelID;
		if(hotelInfoUpdater.addHotel(vo)){
			String password = SimpleCoder.AESEncode("336336", "123456");
			DataFactory.getUserDataService().addUser(hotelID, password);
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean updateHotelWorker(HotelVO vo) {
		HotelInfoUpdater hotelInfoUpdater = BLFactory.getHotelInfoUpdater();
		return hotelInfoUpdater.updateWorkerInfo(vo);
	}

	@Override
	public List<WebMarketerVO> getWebMarketerList() {
		List<WebMarketerVO> result = new ArrayList<WebMarketerVO>();
		List<WebMarketerPO> webMarketerList = DataFactory.getUserDataService().getWebMarketerList();
		for (WebMarketerPO po : webMarketerList) {
			WebMarketerVO vo = new WebMarketerVO(po.getWebMarketerID(), po.getName(), po.getPhoneNumber());
			result.add(vo);
		}
		return result;
	}

	@Override
	public boolean addWebMarketer(WebMarketerVO vo) {
		int id = DataFactory.getUserDataService().getWebMarketerList().size() + 400000001;
		WebMarketerPO po = new WebMarketerPO(id, vo.name, vo.phoneNumber);
		
		
		
		if(DataFactory.getUserDataService().insertWebMarketer(po)){
			String password = SimpleCoder.AESEncode("336336", "123456");
			DataFactory.getUserDataService().addUser(id, password);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateWebMarketer(WebMarketerVO vo) {
		WebMarketerPO po = new WebMarketerPO(vo.ID, vo.name, vo.phoneNumber);

		return DataFactory.getUserDataService().insertWebMarketer(po);
	}

	@Override
	public boolean updateCreditOfCustomer(int customerID, int delta) {
		CustomerInfoUpdater customerInfoUpdater = BLFactory.getCustomerInfoUpdater();
		return customerInfoUpdater.rechargeCredit(customerID, delta);
	}

	@Override
	public String login(int userID, String password) {
		//if(loginTag.containsKey(userID)){
		//	return "has logined";
		//}
		
		String encodePassword = DataFactory.getUserDataService().getPassword(userID);
		if(encodePassword.equals("NOT_FOUND")){
			return "NOT_FOUND";
		}
		
		String realPassword = SimpleCoder.AESDncode("336336", encodePassword);
		String result = "";
		
		if(password.equals(realPassword)){
			System.out.println("right password");
			loginTag.put(userID, true);
			if (userID / 100000000 == 1) {
				System.out.println("customer logs in.");
				result = "customer";
			} else if (userID / 100000000 == 2) {
				System.out.println("hotel worker logs in.");
				result = "hotelWorker";
			} else if (userID / 100000000 == 4) {
				System.out.println("web marketer logs in.");
				result = "webMarketer";
			} else if (userID / 100000000 == 5) {
				System.out.println("web manager logs in.");
				result = "webManager";
			}
			
			return result;
		}
		else{
			return "password wrong";
		}
		
		
	}

}
