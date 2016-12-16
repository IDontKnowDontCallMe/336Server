package businesslogic.orderbl;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogicservice.orderblservice.OrderBLService;
import factory.BLFactory;
import factory.DataFactory;
import vo.CalculationConditionVO;
import vo.OrderVO;

public class OrderBLTest {

	private static OrderBLService orderBLService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DataFactory.initDataFactory();
		BLFactory.initBLFactory();
		orderBLService = BLFactory.getOrderBLService();
	}

	@Test
	public void testGetCustomerOrder() {
		List<OrderVO> list = orderBLService.getCustomerOrder(100000002);
		
		assertEquals(100000002, list.get(0).customerID);
	}
	
	@Test
	public void testGetHotelOrder() {
		List<OrderVO> list = orderBLService.getHotelOrder(200000001);
		
		assertEquals("南大仙林宿舍33", list.get(list.size()-1).hotelName);
	}
	
	@Test
	public void testGetAbnormalOrdersOfToday() {
		List<OrderVO> list = orderBLService.getAbnormalOrdersOfToday();
		
		assertEquals(0, list.size());
	}
	
	@Test
	public void testCalculateTotal() {
		CalculationConditionVO vo = new CalculationConditionVO(200000006, 300000012, 23333, LocalDate.of(2016, 12, 19), LocalDate.of(2016, 12, 20), 3, 11, false, "南京", "鼓楼区");
		
		int actual = orderBLService.calculateTotal(vo);
		
		assertEquals(33, actual);
	}
	
	@Test
	public void testCalculateTotal1() {
		CalculationConditionVO vo = new CalculationConditionVO(200000006, 300000012, 23333, LocalDate.of(2016, 12, 19), LocalDate.of(2016, 12, 20), 3, 11, false, "南京", "鼓楼区");
		
		int actual = orderBLService.calculateTotal(vo);
		
		assertEquals(33, actual);
	}
	
	@Test
	public void testCalculateTotal2() {
		CalculationConditionVO vo = new CalculationConditionVO(200000006, 300000012, 23333, LocalDate.of(2016, 12, 19), LocalDate.of(2016, 12, 20), 4, 11, false, "南京", "鼓楼区");
		
		int actual = orderBLService.calculateTotal(vo);
		
		assertEquals(33, actual);
	}
	
	@Test
	public void testCalculateTotal3() {
		CalculationConditionVO vo = new CalculationConditionVO(200000006, 300000012, 23333, LocalDate.of(2016, 12, 19), LocalDate.of(2016, 12, 20), 5, 11, false, "南京", "鼓楼区");
		
		int actual = orderBLService.calculateTotal(vo);
		
		assertEquals(33, actual);
	}
	
	@Test
	public void testCanBeProduced1() {
		CalculationConditionVO vo = new CalculationConditionVO(200000006, 300000012, 23333, LocalDate.of(2016, 12, 19), LocalDate.of(2016, 12, 20), 1, 11, false, "南京", "鼓楼区");
		
		String actual = orderBLService.canBeProduced(vo);
		
		assertEquals("房间充足", actual);
	}
	
	@Test
	public void testCanBeProduced2() {
		CalculationConditionVO vo = new CalculationConditionVO(200000006, 300000012, 23333, LocalDate.of(2016, 12, 19), LocalDate.of(2016, 12, 20), 2, 11, false, "南京", "鼓楼区");
		
		String actual = orderBLService.canBeProduced(vo);
		
		assertEquals("房间充足", actual);
	}
	
	@Test
	public void testCanBeProduced3() {
		CalculationConditionVO vo = new CalculationConditionVO(200000006, 300000012, 23333, LocalDate.of(2016, 12, 19), LocalDate.of(2016, 12, 20), 566, 11, false, "南京", "鼓楼区");
		
		String actual = orderBLService.canBeProduced(vo);
		
		assertEquals("房间不足", actual);
	}
	
	@Test
	public void testCanBeProduced4() {
		CalculationConditionVO vo = new CalculationConditionVO(200000006, 300000012, 23333, LocalDate.of(2016, 12, 19), LocalDate.of(2016, 12, 20), 5999, 11, false, "南京", "鼓楼区");
		
		String actual = orderBLService.canBeProduced(vo);
		
		assertEquals("房间不足", actual);
	}
	
	@Test
	public void testGetBookedTag1() {
		
		int actual = orderBLService.getBookedTag(100000001, 200000001);
		
		assertEquals(1, actual);
		
	}
	
	@Test
	public void testGetBookedTag2() {
		
		int actual = orderBLService.getBookedTag(100000002, 200000012);
		
		assertEquals(0, actual);
		
	}
	
	@Test
	public void testGetBookedTag3() {
		
		int actual = orderBLService.getBookedTag(100000003, 200000010);
		
		assertEquals(0, actual);
		
	}
	

}
