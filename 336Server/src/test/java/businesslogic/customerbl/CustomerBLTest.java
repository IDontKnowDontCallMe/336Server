package businesslogic.customerbl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogicservice.customerblservice.CustomerBLService;
import factory.BLFactory;
import factory.DataFactory;
import vo.CreditVO;
import vo.CustomerVO;

public class CustomerBLTest {

	private static CustomerBLService customerBLService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DataFactory.initDataFactory();
		BLFactory.initBLFactory();
		customerBLService = BLFactory.getCustomerBLService();
	}

	@Test
	public void testGetCustomerInfo1() {
		CustomerVO customerVO = customerBLService.getCustomerInfo(100000001);
		
		assertEquals("王小明", customerVO.customerName);
	}
	
	@Test
	public void testGetCustomerInfo2() {
		CustomerVO customerVO = customerBLService.getCustomerInfo(100000002);
		
		assertEquals("苏小刚", customerVO.customerName);
	}
	
	@Test
	public void testGetCustomerInfo3() {
		CustomerVO customerVO = customerBLService.getCustomerInfo(100000003);
		
		assertEquals("小红", customerVO.customerName);
	}
	
	@Test
	public void testGetCustomerInfo4() {
		CustomerVO customerVO = customerBLService.getCustomerInfo(100000004);
		
		assertEquals("小方", customerVO.customerName);
	}
	
	@Test
	public void testGetCreditList1() {
		List<CreditVO> list = customerBLService.getCreditList(100000001);
		
		assertEquals(18, list.size());
	}
	
	@Test
	public void testGetCreditList2() {
		List<CreditVO> list = customerBLService.getCreditList(100000002);
		
		assertEquals(5, list.size());
	}

}
