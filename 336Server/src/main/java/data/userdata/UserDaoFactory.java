package data.userdata;

public class UserDaoFactory {
	
	private static CustomerDao customerDao;
	private static HotelDao hotelDao;
	private static WebMarketerDao marketerDao;
	
	public static CustomerDao getCustomerDao(){
		if(customerDao==null){
			customerDao = new CustomerDaoImpl();
		}
		return customerDao;
	}
	
	public static HotelDao getHotelDao(){
		if(hotelDao==null){
			hotelDao = new HotelDaoImpl();
		}
		return hotelDao;
	}
	
	public static WebMarketerDao getMarketerDao(){
		if(marketerDao==null){
			marketerDao = new WebMarketerDaoImpl();
		}
		return marketerDao;
	}

}
