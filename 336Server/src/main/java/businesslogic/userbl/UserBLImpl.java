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
		CustomerPO po = new CustomerPO(vo.customerName, vo.phoneNumber, vo.customerID, vo.birthday, vo.companyName,
				vo.credit, vo.level, vo.isBirthVIP, vo.isCompanyVIP);
		DataFactory.getCustomerDataService().updateInfo(po);
		return true;
	}

	@Override
	public boolean addCustomer(CustomerVO customervo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HotelVO> getHotelList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addHotel(HotelVO hotelVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotelWorker(HotelVO hotelVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<WebMarketerVO> getWebMarketerList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateWebMarketer(WebMarketerVO webMarketerVO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWebMarketer(int WebMarketerID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCreditOfCustomer(int customerID, int delta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String login(int userID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
