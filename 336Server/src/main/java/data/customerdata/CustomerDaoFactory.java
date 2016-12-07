package data.customerdata;

public class CustomerDaoFactory {
	
	private static CustomerDao customerInfoDao = null;
	
	public static CustomerDao getCustomerInfoDao(){
		if(customerInfoDao==null){
			customerInfoDao = new CustomerDaoImpl();
		}
		return customerInfoDao;
	}
	

}
