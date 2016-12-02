package factory;

import businesslogicservice.customerblservice.CustomerBLService;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.hotelblservice.OrderForC_H_Service;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.roomblservice.RoomBLService;
import businesslogicservice.userblservice.UserBLService;

public class BLFactory {

	private static CustomerBLService customerBLService;
	private static HotelBLService hotelBLService;
	private static OrderBLService orderBLService;
	private static PromotionBLService promotionBLService;
	private static RoomBLService roomBLService;
	private static UserBLService userBLService;
	
	private static OrderForC_H_Service orderForC_H_Service;
	
	public static CustomerBLService getCustomerBLService(){
		return null;
	}
	
	public static HotelBLService getHotelBLService(){
		return null;
	}
	
	public static OrderBLService getOrderBLService(){
		return null;
	}
	
	public static PromotionBLService getPromotionBLService(){
		return null;
	}
	
	public static RoomBLService getRoomBLService(){
		return null;
	}
	
	public static UserBLService getUserBLService(){
		return null;
	}
	
	public static OrderForC_H_Service getOrderForC_H_Service(){
		return null;
	}
	
}
