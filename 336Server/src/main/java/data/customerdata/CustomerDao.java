package data.customerdata;

import java.util.List;

import po.CreditPO;
import po.CustomerPO;

public interface CustomerDao {
	public CustomerPO getInfo(int customerID);
	
	public boolean updateSimpleInfo(CustomerPO po);
	
	public boolean updateVIP(CustomerPO po);
	
	public boolean updateCredit(int customerID, int delta);
	
	public List<CreditPO> getCreditList(int customerID);

	public boolean addCreditRecord(CreditPO po);
}
