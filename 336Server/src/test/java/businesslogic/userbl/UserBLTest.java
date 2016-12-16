package businesslogic.userbl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogicservice.userblservice.UserBLService;
import factory.BLFactory;
import factory.DataFactory;
import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;


public class UserBLTest {
	
	private static UserBLService userBLService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DataFactory.initDataFactory();
		BLFactory.initBLFactory();
		userBLService = BLFactory.getUserBLService();
	}

	@Test
	public void testGetCustomerList() {
		List<CustomerVO> list = userBLService.getCustomerList();
		
		assertEquals(true, list.size()>0);
	}
	
	@Test
	public void testGetHotelList() {
		List<HotelVO> list = userBLService.getHotelList();
		
		assertEquals(true, list.size()>0);
	}
	
	@Test
	public void testGetWebMarketerList() {
		List<WebMarketerVO> list = userBLService.getWebMarketerList();
		
		assertEquals(true, list.size()>0);
	}
	
	@Test
	public void testLogin1() {
		String actual = userBLService.login(100000002, "3361002");
		assertEquals("customer", actual);
	}
	
	@Test
	public void testLogin2() {
		String actual = userBLService.login(400000001, "3364001");
		assertEquals("webMarketer", actual);
	}
	
	@Test
	public void testLogin3() {
		String actual = userBLService.login(100000003, "336105502");
		assertEquals("password wrong", actual);
	}
	
	@Test
	public void testLogin4() {
		String actual = userBLService.login(400000002, "334461002");
		assertEquals("password wrong", actual);
	}

}
