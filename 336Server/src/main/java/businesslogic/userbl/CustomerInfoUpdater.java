package businesslogic.userbl;

import vo.CustomerVO;

public interface CustomerInfoUpdater {

	public boolean updateSimpleCustomerInfo(CustomerVO customerVO);
	
	public boolean rechargeCredit(int customerID, int delta);
	
}
