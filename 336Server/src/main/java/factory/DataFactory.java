package factory;

import data.customerdata.CustomerDataServiceImpl;
import data.hoteldata.HotelDataServiceImpl;
import data.orderdata.OrderDataServiceImpl;
import data.promotiondata.PromotionDataServiceImpl;
import data.roomdata.RoomDataServiceImpl;
import data.userdata.UserDataServiceImpl;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.UserDataService;

public class DataFactory {
	private static OrderDataService orderDataService;
	private static CustomerDataService  customerDataService;
	private static RoomDataService  roomDataService;
	private static HotelDataService hotelDataService ;
	private static UserDataService userDataService;
	private static PromotionDataService promotionDataService ;
	
	
	public static void initDataFactory(){
		orderDataService = new OrderDataServiceImpl();
		customerDataService = new CustomerDataServiceImpl();
		roomDataService = new RoomDataServiceImpl();
		hotelDataService = new HotelDataServiceImpl();
		userDataService = new UserDataServiceImpl();
		promotionDataService = new PromotionDataServiceImpl();
	}
	
	public static OrderDataService getOrderDataService(){
		
		return orderDataService;
	}
	
	public static CustomerDataService getCustomerDataService(){
		
		return customerDataService;
	}
	
	public static RoomDataService getRoomDataService(){
		
		return roomDataService;
	}
	
	public static HotelDataService getHotelDataService(){
		
		return hotelDataService;
	}
	
	public static UserDataService getUserDataService(){
		
		return userDataService;
	}
	
	public static PromotionDataService getPromotionDataService(){
		
		return promotionDataService;
	}
}
