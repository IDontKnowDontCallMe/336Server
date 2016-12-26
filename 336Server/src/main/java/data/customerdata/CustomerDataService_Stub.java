package data.customerdata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dataservice.customerdataservice.CustomerDataService;
import po.CreditPO;
import po.CustomerPO;

public class CustomerDataService_Stub implements CustomerDataService{
	
	private CustomerPO customerCase;
	private List<CreditPO> creditListCase;
	
	public CustomerDataService_Stub() {
		// TODO Auto-generated constructor stub
		customerCase = new CustomerPO("Stub客户", "13800001234", 100000001, LocalDate.of(1996, 7, 29), null, 500, true, false);
		
		creditListCase = new ArrayList<CreditPO>();
		CreditPO creditPO1 = new CreditPO(100000001, LocalDateTime.of(LocalDate.of(2016, 10, 10), LocalTime.of(10, 10)), "900000001", "订单执行", 150, 500);
		creditListCase.add(creditPO1);
	}
	
	@Override
	public CustomerPO getInfo(int customerID) {
		// TODO Auto-generated method stub
		return customerCase;
	}

	@Override
	public boolean updateSimpleInfo(CustomerPO po) {
		// TODO Auto-generated method stub
		customerCase = po;
		return true;
	}

	@Override
	public boolean updateVIP(CustomerPO po) {
		// TODO Auto-generated method stub
		customerCase.setBirthVIP(po.isBirthVIP());
		customerCase.setVIPbirthday(po.getVIPbirthday());
		customerCase.setCompanyVIP(po.isCompanyVIP());
		customerCase.setVIPcompany(po.getVIPcompany());
		return true;
	}

	@Override
	public boolean updateCredit(int customerID, int delta) {
		// TODO Auto-generated method stub
		customerCase.setCredit(customerCase.getCredit() + delta);
		return true;
	}

	@Override
	public List<CreditPO> getCreditList(int customerID) {
		// TODO Auto-generated method stub
		return creditListCase;
	}

	@Override
	public boolean addCreditRecord(CreditPO po) {
		// TODO Auto-generated method stub
		creditListCase.add(po);
		return true;
	}

}
