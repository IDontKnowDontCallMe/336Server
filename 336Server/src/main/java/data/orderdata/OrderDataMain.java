package data.orderdata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import po.OrderPO;

public class OrderDataMain {

	public static void main(String[] args){
		
		OrderDao orderDao = new OrderDaoImpl();
		
		List<OrderPO> list = orderDao.getAbnormalOrdersOfToday();
		
		/****
		OrderPO po = list.get(0);
		
		System.out.println(po.getProducingDateTime().isAfter(LocalDateTime.now()) );
		
		
		List<OrderPO> list2 = orderDao.getOrderByHotelID(200000001);
		
		System.out.println(list2.size());
		*****/
		
		
		OrderPO po2 = new OrderPO(900000004, "小方", 100000004, LocalDateTime.now(), "南大宿舍", 200000001, "单人房", 1, false, 1, LocalDate.of(2016, 12, 5), LocalTime.of(11, 0), LocalDate.of(2016, 12, 6), 150, "已执行", null, LocalDateTime.now(), null, false);
	
		orderDao.updateOrder(po2);
	}
	
}
