package businesslogic.customerbl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import businesslogic.userbl.CustomerInfoUpdater;
import businesslogicservice.customerblservice.CustomerBLService;
import vo.CreditVO;
import vo.CustomerVO;

/**
 * CustomerBLService的提供者
 * @author sjl
 *
 */
public class CustomerController implements CustomerBLService, CustomerInfoUpdater{
	
	CustomerBLImpl customerblImpl = new CustomerBLImpl();
	
	
	
	@Override
	public CustomerVO getCustomerInfo(int customerID) {
		// TODO Auto-generated method stub
		return customerblImpl.getCustomerInfo(customerID);
	}

	@Override
	public boolean updateCustomerInfo(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return customerblImpl.updateCustomerInfo(customerVO);
	}

	@Override
	public List<CreditVO> getCreditList(int customerID) {
		// TODO Auto-generated method stub
		return customerblImpl.getCreditList(customerID);
	}

	@Override
	public boolean registerCompanyVIP(int customerID, String companyName) {
		// TODO Auto-generated method stub
		return customerblImpl.registerCompanyVIP(customerID, companyName);
	}

	@Override
	public boolean registerBirthVIP(int customerID, LocalDate birthday) {
		// TODO Auto-generated method stub
		return customerblImpl.registerBirthVIP(customerID, birthday);
	}

	@Override
	public boolean updateSimpleCustomerInfo(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return customerblImpl.updateCustomerInfo(customerVO);
	}

	@Override
	public boolean rechargeCredit(int customerID, int delta) {
		// TODO Auto-generated method stub
		CreditVO creditVO = new CreditVO(customerID, LocalDateTime.now(), "无", "信用充值", delta, -1);
		return customerblImpl.addCreditRecord(creditVO);
	}

	@Override
	public boolean addCreditRecord(CreditVO creditVO) {
		// TODO Auto-generated method stub
		return customerblImpl.addCreditRecord(creditVO);
	}

}
