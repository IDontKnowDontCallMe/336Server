package data.customerdata;

import po.CustomerPO;

public class CustomerDataTest {

	public static void main(String[] args){
		CustomerDataServiceImpl customerDataServiceImpl = new CustomerDataServiceImpl();
		CustomerPO customerPO = customerDataServiceImpl.getInfo(100000001);
		
		if(customerPO!=null) System.out.println(customerPO.getName());
		else {
			System.out.print("null");
		}
	}
	
}
