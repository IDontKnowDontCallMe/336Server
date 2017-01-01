package businesslogic.promotionbl;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import factory.BLFactory;
import factory.DataFactory;
import vo.CalculationConditionVO;
import vo.CustomerVO;

public class PromotionBLTest {

	private static PromotionBLService promotionBLService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DataFactory.initDataFactory();
		BLFactory.initBLFactory();
		promotionBLService = BLFactory.getPromotionBLService();
	}

	@Test
	public void testCalculateLevel1() {
		int actual = promotionBLService.calculateLevel(100);
		
		assertEquals(0, actual);
	}

	@Test
	public void testCalculateLevel2() {
		int actual = promotionBLService.calculateLevel(2033);
		
		assertEquals(2, actual);
	}
	
	@Test
	public void testCalculateLevel3() {
		int actual = promotionBLService.calculateLevel(300);
		
		assertEquals(0, actual);
	}
	
	@Test
	public void testCalculateLevel4() {
		int actual = promotionBLService.calculateLevel(500000);
		
		assertEquals(15, actual);
	}
	
	@Test
	public void testCalculateLevel5() {
		int actual = promotionBLService.calculateLevel(3665);
		
		assertEquals(3, actual);
	}
	
	@Test
	public void testCalculateLevel6() {
		int actual = promotionBLService.calculateLevel(9000);
		
		assertEquals(9, actual);
	}
	
	@Test
	public void testcalculateOrder1() {
		CalculationConditionVO calculationConditionVO = new CalculationConditionVO(200000001, 300000001, 100000001, LocalDate.of(2016, 12, 17), LocalDate.of(2016, 12, 18), 1, 150, false, "南京", "栖霞区");
		CustomerVO customerVO = new CustomerVO(100000001, "", "", false, null, false, null, 3000, 3);
		int actual = promotionBLService.calculateOrder(calculationConditionVO, customerVO);
		
<<<<<<< HEAD
		assertEquals(125, actual);
=======
		assertEquals(115, actual);
>>>>>>> refs/remotes/origin/master
	}
	
	@Test
	public void testcalculateOrder2() {
		CalculationConditionVO calculationConditionVO = new CalculationConditionVO(200000001, 300000001, 100000001, LocalDate.of(2016, 12, 17), LocalDate.of(2016, 12, 18), 1, 150, false, "南京", "栖霞区");
		CustomerVO customerVO = new CustomerVO(100000001, "", "", false, null, false, null, 3000, 3);
		int actual = promotionBLService.calculateOrder(calculationConditionVO, customerVO);
		
<<<<<<< HEAD
		assertEquals(125, actual);
=======
		assertEquals(115, actual);
>>>>>>> refs/remotes/origin/master
	}
	
	@Test
	public void testcalculateOrder3() {
		CalculationConditionVO calculationConditionVO = new CalculationConditionVO(200000001, 300000001, 100000001, LocalDate.of(2016, 12, 17), LocalDate.of(2016, 12, 18), 1, 150, false, "南京", "栖霞区");
		CustomerVO customerVO = new CustomerVO(100000001, "", "", false, null, false, null, 3000, 3);
		int actual = promotionBLService.calculateOrder(calculationConditionVO, customerVO);
		
<<<<<<< HEAD
		assertEquals(125, actual);
=======
		assertEquals(115, actual);
>>>>>>> refs/remotes/origin/master
	}
}
