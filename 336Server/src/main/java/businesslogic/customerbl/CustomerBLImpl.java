package businesslogic.customerbl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import factory.BLFactory;
import factory.DataFactory;
import po.CreditPO;
import po.CustomerPO;
import vo.CreditVO;
import vo.CustomerVO;

public class CustomerBLImpl {
	
	public CustomerVO getCustomerInfo(int customerID) {
		CustomerPO customerPO = DataFactory.getCustomerDataService().getInfo(customerID);
		
		
		int level = BLFactory.getPromotionBLService().calculateLevel(customerPO.getCredit());

		
		CustomerVO customerVO = new CustomerVO(customerPO.getID(), customerPO.getName(), customerPO.getPhoneNumber(), customerPO.isBirthVIP(), customerPO.getVIPbirthday(), customerPO.isCompanyVIP(), customerPO.getVIPcompany(), customerPO.getCredit(), level);
		return customerVO;
	}
	
	public boolean updateCustomerInfo(CustomerVO customerVO) {
		if (customerVO != null) {
			CustomerPO customerPO = new CustomerPO(customerVO.customerName, customerVO.phoneNumber, customerVO.customerID, customerVO.birthday, customerVO.companyName, customerVO.credit,  customerVO.isBirthVIP, customerVO.isCompanyVIP);
			System.out.println("update customer");
			return DataFactory.getCustomerDataService().updateSimpleInfo(customerPO);
		}else{
			return false;
		}
	}
	/***   用addCreditRecor方法替代之
	public boolean updateCredit(int customerID, int delta){
		factory.DataFactory.getCustomerDataService().updateCredit(customerID, delta);
		return true;
	}
	***/
	
	/***
	public boolean addCreditRecord(CreditPO creditPO){
		DataFactory.getCustomerDataService().addCreditRecord(creditPO);
		return  true;
	}
	***/
	
	public List<CreditVO> getCreditList(int customerID) {
		List<CreditPO> creditPOList= DataFactory.getCustomerDataService().getCreditList(customerID);
		List<CreditVO> creditVOList = new ArrayList<CreditVO>();
		for(CreditPO po:creditPOList){
			CreditVO creditVO = new CreditVO(customerID, po.getTime(), po.getOrderID(), po.getActionType(), po.getDelta(), po.getResult());
			creditVOList.add(creditVO);
		}
		return creditVOList;
	}
	
	public boolean registerBirthVIP(int customerID, LocalDate birthday) {
		CustomerPO po = new CustomerPO(null, null, customerID, birthday, null, -1, true, false);
		
		return DataFactory.getCustomerDataService().updateVIP(po);
	}

	public boolean registerCompanyVIP(int customerID, String companyName) {
		CustomerPO po = new CustomerPO(null, null, customerID, null, companyName, -1, false, true);
		
		return DataFactory.getCustomerDataService().updateVIP(po);
	}

	public boolean addCreditRecord(CreditVO creditVO){
		CreditPO creditPO = new CreditPO(creditVO.customerID, LocalDateTime.now(), creditVO.orderID, creditVO.action, creditVO.creditDelta, -1);
		return factory.DataFactory.getCustomerDataService().addCreditRecord(creditPO);
	}
	

}
