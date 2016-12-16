package businesslogic.hotelbl;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogicservice.hotelblservice.HotelBLService;
import factory.BLFactory;
import factory.DataFactory;
import vo.AreaVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.SearchConditionVO;

public class HotelBLTest {

	private static HotelBLService hotelBLService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DataFactory.initDataFactory();
		BLFactory.initBLFactory();
		hotelBLService = BLFactory.getHotelBLService();
	}

	@Test
	public void testGetHotelVOsOfArea() {
		AreaVO areaVO = new AreaVO("南京", "鼓楼区");
		int customerID = 100000001;
		
		List<HotelVO> list = hotelBLService.getHotelVOsOfArea(areaVO, customerID);
		
		assertEquals(10 , list.size());
		
	}
	
	@Test
	public void testSearch1() {
		AreaVO areaVO = new AreaVO("南京", "鼓楼区");
		SearchConditionVO searchConditionVO = new SearchConditionVO(100000001, "", true, 2, false, 1, 2, true, LocalDate.of(2016, 12, 25), LocalDate.of(2016, 12, 26), 5, false	, 1	, false, 1, false, true);
		
		List<HotelVO> list = hotelBLService.search(areaVO, searchConditionVO);
		
		assertEquals(true , list.size()>0);
		
	}
	
	@Test
	public void testSearch2() {
		AreaVO areaVO = new AreaVO("南京", "栖霞区");
		SearchConditionVO searchConditionVO = new SearchConditionVO(100000001, "", true, 2, false, 1, 2, true, LocalDate.of(2016, 12, 25), LocalDate.of(2016, 12, 26), 2000, false	, 1	, false, 1, false, true);
		
		List<HotelVO> list = hotelBLService.search(areaVO, searchConditionVO);
		
		assertEquals(false , list.size()>0);
		
	}
	
	@Test
	public void testSearch3() {
		AreaVO areaVO = new AreaVO("南京", "秦淮区");
		SearchConditionVO searchConditionVO = new SearchConditionVO(100000001, "", true, 2, false, 1, 2, true, LocalDate.of(2016, 12, 25), LocalDate.of(2016, 12, 26), 5, false	, 1	, false, 1, false, true);
		
		List<HotelVO> list = hotelBLService.search(areaVO, searchConditionVO);
		
		assertEquals(true , list.size()>0);
		
	}
	
	@Test
	public void testGetOrderListOfHotel() {
		
		List<OrderVO> list = hotelBLService.getOrderListOfHotel(200000005, 100000003);
		
		assertEquals(3, list.size());
		assertEquals(900000020, list.get(0).orderID);
		assertEquals(900000021, list.get(1).orderID);
		assertEquals(900000022, list.get(2).orderID);
	}
	
	@Test
	public void testGetBookedHotelList() {
		
		List<HotelVO> list = hotelBLService.getBookedHotelList(100000002);
		
		assertEquals(2, list.size());
		assertEquals("很便宜的酒店", list.get(1).hotelName);
	}

}
