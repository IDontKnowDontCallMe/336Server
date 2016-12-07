package businesslogicservice.customerblservice;

import java.time.LocalDate;
import java.util.List;

import vo.CreditVO;
import vo.CustomerVO;

public interface CustomerBLService{


	public CustomerVO getCustomerInfo(int customerID);
	
	public boolean updateCustomerInfo(CustomerVO customerVO);
	
	public List<CreditVO> getCreditList(int customerID);
	
	public boolean addCreditRecord(CreditVO creditVO);
	
	public boolean registerBirthVIP(int customerID, LocalDate birthday);
	
	public boolean registerCompanyVIP(int customerID, String companyName);
	
	
	
}
