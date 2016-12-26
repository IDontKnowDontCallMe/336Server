package businesslogic.customerbl;

import java.awt.TexturePaint;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.customerblservice.CustomerBLService;
import po.CreditPO;
import vo.CreditVO;
import vo.CustomerVO;

public class CustomerBLService_Stub implements CustomerBLService{

	private CustomerVO customerVO = new CustomerVO(100000001, "Stub客户", "1380000000", true, LocalDate.of(1996, 7, 29), false, null, 500, 0);
	private List<CreditVO> creditList;
	
	public CustomerBLService_Stub() {
		// TODO Auto-generated constructor stub
		creditList = new ArrayList<CreditVO>();
		CreditVO creditVO = new CreditVO(100000001, LocalDateTime.of(LocalDate.of(2016, 10, 10), LocalTime.of(10, 10)), "900000001", "订单执行", 150, 500);
		creditList.add(creditVO);
	}
	
	@Override
	public CustomerVO getCustomerInfo(int customerID) {
		// TODO Auto-generated method stub
		return customerVO;
	}

	@Override
	public boolean updateCustomerInfo(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		System.out.println("update customerVO");
		return true;
	}

	@Override
	public List<CreditVO> getCreditList(int customerID) {
		// TODO Auto-generated method stub
		return creditList;
	}

	@Override
	public boolean addCreditRecord(CreditVO creditVO) {
		// TODO Auto-generated method stub
		creditList.add(creditVO);
		System.out.println("add credit record");
		return true;
	}

	@Override
	public boolean registerBirthVIP(int customerID, LocalDate birthday) {
		// TODO Auto-generated method stub
		System.out.println("registerBirthVIP");
		return true;
	}

	@Override
	public boolean registerCompanyVIP(int customerID, String companyName) {
		// TODO Auto-generated method stub
		System.out.println("registerCompanyVIP");
		return true;
	}

}
