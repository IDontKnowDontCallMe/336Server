package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.userblservice.UserBLService;
import factory.DataFactory;
import po.CustomerPO;
import po.HotelPO;
import po.WebMarketerPO;
import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;

public class UserBLImpl implements UserBLService {

	private List<CustomerPO> customerList;
	private List<HotelPO> hotelList;
	private List<WebMarketerPO> webMarketerList;

	@Override
	public List<CustomerVO> getCustomerList() throws RemoteException {
		List<CustomerVO> result = new ArrayList<CustomerVO>();
		for (CustomerPO po : customerList) {
			CustomerVO vo = new CustomerVO(po.getID(), po.getName(), po.getPhoneNumber(), po.isBirthVIP(),
					po.getVIPbirthday(), po.isCompVIP(), po.getVIPcompany(), po.getCredit(), po.getLevel());
			result.add(vo);
		}
		return result;
	}

	@Override
	public boolean updateCustomer(CustomerVO vo) throws RemoteException {
		DataFactory.getUserDataService().deleteCustomer(vo.customerID);
		CustomerPO po = new CustomerPO(vo.customerName, vo.phoneNumber, vo.customerID, vo.birthday, vo.companyName,
				vo.credit, vo.level, vo.isBirthVIP, vo.isCompanyVIP);
		DataFactory.getUserDataService().insertCustomer(po);
		return true;
	}

	@Override
	public boolean addCustomer(CustomerVO vo) throws RemoteException {
		CustomerPO po = new CustomerPO(vo.customerName, vo.phoneNumber, vo.customerID, vo.birthday, vo.companyName,
				vo.credit, vo.level, vo.isBirthVIP, vo.isCompanyVIP);
		DataFactory.getUserDataService().insertCustomer(po);
		return true;
	}

	@Override
	public List<HotelVO> getHotelList() throws RemoteException {
		List<HotelVO> result = new ArrayList<HotelVO>();
		for (HotelPO po : hotelList) {
			HotelVO vo = new HotelVO(po.getHotelID(), po.getHotelName(), po.getCity(), po.getBusinessCircle(),
					po.getAddress(), po.getIntroduction(), po.getService(), po.getScore(), po.getCommentScore(),
					po.getWorkerName(), po.getPhoneNumber(), po.getMinPrice(), po.getBookedTag());
			result.add(vo);
		}
		return result;
	}

	@Override
	public boolean addHotel(HotelVO vo) throws RemoteException {
		HotelPO po = new HotelPO(vo.hotelID, vo.hotelName, vo.city, vo.businessCircle, vo.address, vo.introduction,
				vo.service, vo.workerName, vo.phoneNumber, vo.score, vo.commentScore, vo.minPrice, vo.bookedTag);
		DataFactory.getUserDataService().insertHotel(po);
		return true;
	}

	@Override
	public boolean updateHotelWorker(HotelVO vo) throws RemoteException {
		DataFactory.getUserDataService().deleteHotel(vo.hotelID);
		HotelPO po = new HotelPO(vo.hotelID, vo.hotelName, vo.city, vo.businessCircle, vo.address, vo.introduction,
				vo.service, vo.workerName, vo.phoneNumber, vo.score, vo.commentScore, vo.minPrice, vo.bookedTag);
		DataFactory.getUserDataService().insertHotel(po);
		return true;
	}

	@Override
	public List<WebMarketerVO> getWebMarketerList() throws RemoteException {
		List<WebMarketerVO> result = new ArrayList<WebMarketerVO>();
		for (WebMarketerPO po : webMarketerList) {
			WebMarketerVO vo = new WebMarketerVO(po.getWebMarketerID(), po.getName(), po.getPhoneNumber());
			result.add(vo);
		}
		return result;
	}

	@Override
	public boolean addWebMarketer(WebMarketerVO vo) throws RemoteException {
		WebMarketerPO po = new WebMarketerPO(vo.ID, vo.name, vo.phoneNumber);
		DataFactory.getUserDataService().insertWebMarketer(po);
		return true;
	}

	@Override
	public boolean updateWebMarketer(WebMarketerVO vo) throws RemoteException {
		DataFactory.getUserDataService().deleteWebMarketer(vo.ID);
		WebMarketerPO po = new WebMarketerPO(vo.ID, vo.name, vo.phoneNumber);
		DataFactory.getUserDataService().insertWebMarketer(po);
		return true;
	}

	@Override
	public boolean updateCreditOfCustomer(int customerID, int delta) {
		DataFactory.getUserDataService().deleteCustomer(customerID);
		CustomerPO temp = null;
		for (CustomerPO po : customerList) {
			if (po.getID() == customerID) {
				temp = po;
				break;
			}
		}
		temp.setCredit(temp.getCredit() + delta);
		DataFactory.getUserDataService().insertCustomer(temp);
		return false;
	}

	@Override
	public String login(int userID, String password) throws RemoteException {
		if (userID / 100000000 == 1) {
			System.out.println("customer logs in.");
			return "customer";
		} else if (userID / 100000000 == 2) {
			System.out.println("hotel worker logs in.");
			return "hotelWorker";
		} else if (userID / 100000000 == 3) {
			System.out.println("web marketer logs in.");
			return "webMarketer";
		} else if (userID / 100000000 == 4) {
			System.out.println("web manager logs in.");
			return "webManager";
		} else {
			System.out.println("wrong userID.");
			return null;
		}
	}

}
