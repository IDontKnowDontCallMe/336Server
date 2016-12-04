package factory;

import businesslogic.customerbl.CustomerBLImpl;
import businesslogic.customerbl.CustomerController;
import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.OrderController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.roombl.RoomController;
import businesslogic.userbl.UserController;
import businesslogicservice.customerblservice.CustomerBLService;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.hotelblservice.OrderForC_H_Service;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.roomblservice.RoomBLService;
import businesslogicservice.userblservice.UserBLService;
import data.customerdata.CustomerDataServiceImpl;

public class BLFactory {

	private static CustomerBLService customerBLService;
	private static HotelBLService hotelBLService;
	private static OrderBLService orderBLService;
	private static PromotionBLService promotionBLService;
	private static RoomBLService roomBLService;
	private static UserBLService userBLService;
	
	public static void initBLFactory(){
		customerBLService = new CustomerController();
		hotelBLService = new HotelController();
		orderBLService = new OrderController();
		promotionBLService = new PromotionController();
		roomBLService = new RoomController();
		userBLService = new UserController();
	}
	
	public static CustomerBLService getCustomerBLService(){
		return customerBLService;
	}
	
	public static HotelBLService getHotelBLService(){
		return hotelBLService;
	}
	
	public static OrderBLService getOrderBLService(){
		return orderBLService;
	}
	
	public static PromotionBLService getPromotionBLService(){
		return promotionBLService;
	}
	
	public static RoomBLService getRoomBLService(){
		return roomBLService;
	}
	
	public static UserBLService getUserBLService(){
		return userBLService;
	}
	
	
	
}
