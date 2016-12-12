package data.customerdata;

import data.userdata.UserDataServiceImpl;
import po.CustomerPO;

public class CustomerDataTest {

	public static void main(String[] args){
		UserDataServiceImpl userDataServiceImpl = new UserDataServiceImpl();
		CustomerPO customerPO = new CustomerPO("556", "110", 0, null, null, 0, false, false);
		
		if(userDataServiceImpl.insertCustomer(customerPO)>0) System.out.println(customerPO.getName());
		else {
			System.out.print("null");
		}
	}
	
}
