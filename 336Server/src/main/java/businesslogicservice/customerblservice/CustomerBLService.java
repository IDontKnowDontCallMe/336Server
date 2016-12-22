package businesslogicservice.customerblservice;

import java.time.LocalDate;
import java.util.List;

import vo.CreditVO;
import vo.CustomerVO;

/**
 * CustomerBL模块提供的接口
 * @author tx
 *
 */
public interface CustomerBLService{


	/**
	 * 获得客户信息
	 * @param customerID
	 * @return 对应该CustomerID的客户信息VO
	 */
	public CustomerVO getCustomerInfo(int customerID);
	
	/**
	 * 更新客户基本信息
	 * @param customerVO
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean updateCustomerInfo(CustomerVO customerVO);
	
	/**
	 * 获得客户信用变化列表
	 * @param customerID
	 * @return 该客户的信用变化列表；若无信用变化，列表size为0
	 */
	public List<CreditVO> getCreditList(int customerID);
	
	/**
	 * 给某客户添加一条信用变化记录
	 * @param creditVO
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addCreditRecord(CreditVO creditVO);
	
	/**
	 * 客户注册生日会员
	 * @param customerID
	 * @param birthday
	 * @return 注册成功返回true，否则返回false
	 */
	public boolean registerBirthVIP(int customerID, LocalDate birthday);
	
	/**
	 * 客户注册企业会员
	 * @param customerID
	 * @param companyName
	 * @return 注册成功返回true，否则返回false
	 */
	public boolean registerCompanyVIP(int customerID, String companyName);
	
	
	
}
