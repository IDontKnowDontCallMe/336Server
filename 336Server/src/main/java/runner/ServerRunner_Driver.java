package runner;

import java.time.LocalDate;
import java.util.List;
import businesslogic.customerbl.CustomerBLService_Stub;
import businesslogic.hotelbl.HotelBLService_Stub;
import businesslogic.orderbl.OrderBLService_Stub;
import businesslogic.promotionbl.PromotionBLService_Stub;
import businesslogic.roombl.RoomBLService_Stub;
import businesslogic.userbl.UserBLService_Stub;
import businesslogicservice.customerblservice.CustomerBLService;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.roomblservice.RoomBLService;
import businesslogicservice.userblservice.UserBLService;
import data.customerdata.CustomerDataService_Stub;
import data.hoteldata.HotelDataService_Stub;
import data.orderdata.OrderDataService_Stub;
import data.promotiondata.PromotionDateService_Stub;
import data.roomdata.RoomDataService_Stub;
import data.userdata.UserDataService_Stub;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.UserDataService;
import vo.AreaVO;
import vo.HotelVO;
import vo.SearchConditionVO;

public class ServerRunner_Driver {
	
	private CustomerBLService customerBLService = null;
	private HotelBLService hotelBLService = null;
	private OrderBLService orderBLService = null;
	private PromotionBLService promotionBLService = null;
	private RoomBLService roomBLService = null;
	private UserBLService userBLService = null;
	
	private CustomerDataService customerDataService = null;
	private HotelDataService hotelDataService = null;
	private OrderDataService orderDataService = null;
	private PromotionDataService promotionDataService = null;
	private RoomDataService roomDataService = null;
	private UserDataService userDataService = null;
	
	public static void main(String[] args){
		CustomerBLService customerBLService = new CustomerBLService_Stub();
		HotelBLService hotelBLService = new HotelBLService_Stub();
		OrderBLService orderBLService = new OrderBLService_Stub();
		PromotionBLService promotionBLService = new PromotionBLService_Stub();
		RoomBLService roomBLService = new RoomBLService_Stub();
		UserBLService userBLService = new UserBLService_Stub();
		
		CustomerDataService customerDataService = new CustomerDataService_Stub();
		HotelDataService hotelDataService = new HotelDataService_Stub();
		OrderDataService orderDataService = new OrderDataService_Stub();
		PromotionDataService promotionDataService = new PromotionDateService_Stub();
		RoomDataService roomDataService = new RoomDataService_Stub();
		UserDataService userDataService = new UserDataService_Stub();
		
		ServerRunner_Driver driver = new ServerRunner_Driver();
		driver.setCustomerBLService(customerBLService);
		driver.setHotelBLService(hotelBLService);
		driver.setOrderBLService(orderBLService);
		driver.setPromotionBLService(promotionBLService);
		driver.setRoomBLService(roomBLService);
		driver.setUserBLService(userBLService);
		driver.setCustomerDataService(customerDataService);
		driver.setHotelDataService(hotelDataService);
		driver.setOrderDataService(orderDataService);
		driver.setPromotionDataService(promotionDataService);
		driver.setRoomDataService(roomDataService);
		driver.setUserDataService(userDataService);
		
		driver.drive();
	}
	
	public void drive(){
		
		//CustomerVO customerVO = customerBLService.getCustomerInfo(100000001);
		//System.out.println(customerVO.customerName);
		
		List<HotelVO> hotelList = hotelBLService.search(new AreaVO("南京", "栖霞区"), new SearchConditionVO(100000001, "", false, 0, false, 0, 0, false, null, null, 0, false, 0, false, 0, false, false));
		System.out.println(hotelList.get(0));
		
		customerBLService.registerBirthVIP(100000001, LocalDate.of(1997, 1, 1));
	}
	
	public void setCustomerBLService(CustomerBLService customerBLService){
		this.customerBLService = customerBLService;
	}
	
	public void setHotelBLService(HotelBLService hotelBLService){
		this.hotelBLService = hotelBLService;
	}
	
	public void setOrderBLService(OrderBLService orderBLService){
		this.orderBLService = orderBLService;
	}
	
	public void setPromotionBLService(PromotionBLService promotionBLService){
		this.promotionBLService= promotionBLService;
	}
	
	public void setRoomBLService(RoomBLService roomBLService){
		this.roomBLService = roomBLService;
	}
	
	public void setUserBLService(UserBLService userBLService){
		this.userBLService = userBLService;
	}
	
	public void setCustomerDataService(CustomerDataService customerDataService){
		this.customerDataService = customerDataService;
	}
	
	public void setHotelDataService(HotelDataService hotelDataService){
		this.hotelDataService = hotelDataService;
	}
	
	public void setOrderDataService(OrderDataService orderDataService){
		this.orderDataService = orderDataService;
	}
	
	public void setPromotionDataService(PromotionDataService promotionDataService){
		this.promotionDataService= promotionDataService;
	}
	
	public void setRoomDataService(RoomDataService roomDataService){
		this.roomDataService = roomDataService;
	}
	
	public void setUserDataService(UserDataService userDataService){
		this.userDataService = userDataService;
	}
	

}
