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
		
		OrderPO orderPO = new OrderPO(555, null, 88, null, null, 555, null, 11, false, 99, null, null, LocalDate.now(), 55, "44", null, null, null, true);
		
		System.out.println(orderDao.insertOrder(orderPO));
		
		/****
		OrderPO po = list.get(0);
		
		System.out.println(po.getProducingDateTime().isAfter(LocalDateTime.now()) );
		
		
		List<OrderPO> list2 = orderDao.getOrderByHotelID(200000001);
		
		System.out.println(list2.size());
		*****/
		
		
		
	}
	
}
