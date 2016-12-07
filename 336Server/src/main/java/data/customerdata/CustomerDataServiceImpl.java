package data.customerdata;

import java.util.List;
import dataservice.customerdataservice.CustomerDataService;
import po.CreditPO;
import po.CustomerPO;

public class CustomerDataServiceImpl implements CustomerDataService{

	private CustomerDao customerDao = CustomerDaoFactory.getCustomerInfoDao();
	
	@Override
	public CustomerPO getInfo(int customerID) {
		// TODO Auto-generated method stub
		return customerDao.getInfo(customerID);
	}

	@Override
	public boolean updateSimpleInfo(CustomerPO po) {
		// TODO Auto-generated method stub
		return customerDao.updateSimpleInfo(po);
	}

	@Override
	public boolean updateVIP(CustomerPO po) {
		// TODO Auto-generated method stub
		return customerDao.updateVIP(po);
	}

	@Override
	public List<CreditPO> getCreditList(int customerID) {
		// TODO Auto-generated method stub
		return customerDao.getCreditList(customerID);
	}

	@Override
	public boolean addCreditRecord(CreditPO po) {
		// TODO Auto-generated method stub
		return customerDao.addCreditRecord(po);
	}

	@Override
	public boolean updateCredit(int customerID, int delta) {
		// TODO Auto-generated method stub
		return customerDao.updateCredit(customerID, delta);
	}
	
	


}
