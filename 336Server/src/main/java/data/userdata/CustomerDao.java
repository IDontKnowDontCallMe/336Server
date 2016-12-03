package data.userdata;

import java.util.List;

import po.CustomerPO;

public interface CustomerDao {

	public List<CustomerPO> getCustomerList();

	public boolean deleteCustomer(int customerID);

	public boolean insertCustomer(CustomerPO po);
	
}
