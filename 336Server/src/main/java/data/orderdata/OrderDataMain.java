package data.orderdata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import po.OrderPO;

public class OrderDataMain {

	public static void main(String[] args){
		
		OrderDataServiceImpl orderDao = new OrderDataServiceImpl();
		
		List<OrderPO> list = orderDao.getAbnormalOrdersOfToday();
		
		System.out.println(list.get(0).getCustomerName());
		
		/****
		OrderPO po = list.get(0);
		
		System.out.println(po.getProducingDateTime().isAfter(LocalDateTime.now()) );
		
		
		List<OrderPO> list2 = orderDao.getOrderByHotelID(200000001);
		
		System.out.println(list2.size());
		*****/
		
		
		
	}
	
}
