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

/**
 * 	CustomerBLService的实现类
 * @author sjl
 *
 */
public class CustomerBLImpl {
	
	/**
	 * 
	 * @param customerID
	 * @return 对应customerID的VO
	 */
	public CustomerVO getCustomerInfo(int customerID) {
		CustomerPO customerPO = DataFactory.getCustomerDataService().getInfo(customerID);
		
		
		int level = BLFactory.getPromotionBLService().calculateLevel(customerPO.getCredit());

		
		CustomerVO customerVO = new CustomerVO(customerPO.getID(), customerPO.getName(), customerPO.getPhoneNumber(), customerPO.isBirthVIP(), customerPO.getVIPbirthday(), customerPO.isCompanyVIP(), customerPO.getVIPcompany(), customerPO.getCredit(), level);
		return customerVO;
	}
	
	
	/**
	 * 更新客户基本信息
	 * @param customerVO
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean updateCustomerInfo(CustomerVO customerVO) {
		if (customerVO != null) {
			CustomerPO customerPO = new CustomerPO(customerVO.customerName, customerVO.phoneNumber, customerVO.customerID, customerVO.birthday, customerVO.companyName, customerVO.credit,  customerVO.isBirthVIP, customerVO.isCompanyVIP);
			System.out.println("update customer");
			return DataFactory.getCustomerDataService().updateSimpleInfo(customerPO);
		}else{
			return false;
		}
	}
	
	
	/**
	 * 获得客户信用变化列表
	 * @param customerID
	 * @return 对应customer的所有信用变化的列表；若无信用变化，返回列表size为0
	 */
	public List<CreditVO> getCreditList(int customerID) {
		List<CreditPO> creditPOList= DataFactory.getCustomerDataService().getCreditList(customerID);
		List<CreditVO> creditVOList = new ArrayList<CreditVO>();
		for(CreditPO po:creditPOList){
			CreditVO creditVO = new CreditVO(customerID, po.getTime(), po.getOrderID(), po.getActionType(), po.getDelta(), po.getResult());
			creditVOList.add(creditVO);
		}
		return creditVOList;
	}
	
	/**
	 * 客户注册生日会员的方法
	 * @param customerID
	 * @param birthday
	 * @return 注册成功返回true，否则返回false
	 */
	public boolean registerBirthVIP(int customerID, LocalDate birthday) {
		CustomerPO po = new CustomerPO(null, null, customerID, birthday, null, -1, true, false);
		
		return DataFactory.getCustomerDataService().updateVIP(po);
	}

	/**
	 * 客户注册企业会员
	 * @param customerID
	 * @param companyName
	 * @return 注册成功返回true，否则返回false
	 */
	public boolean registerCompanyVIP(int customerID, String companyName) {
		CustomerPO po = new CustomerPO(null, null, customerID, null, companyName, -1, false, true);
		
		return DataFactory.getCustomerDataService().updateVIP(po);
	}

	/**
	 * 添加一条对应客户的信用变化
	 * @param creditVO
	 * @return 添加成功返回true，否则false
	 */
	public boolean addCreditRecord(CreditVO creditVO){
		CreditPO creditPO = new CreditPO(creditVO.customerID, LocalDateTime.now(), creditVO.orderID, creditVO.action, creditVO.creditDelta, -1);
		return factory.DataFactory.getCustomerDataService().addCreditRecord(creditPO);
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
}
