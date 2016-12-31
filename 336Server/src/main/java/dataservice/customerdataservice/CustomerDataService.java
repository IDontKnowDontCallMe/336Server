package dataservice.customerdataservice;

import java.util.List;
import po.CreditPO;
import po.CustomerPO;

/**
 * CustomerData模块的接口
 * @author sjl
 *
 */
public interface CustomerDataService {

	/**
	 * 获得一条客户信息的记录
	 * @param customerID
	 * @return 客户信息的记录
	 */
	public CustomerPO getInfo(int customerID);
	
	/**
	 * 更新一条客户信息
	 * @param po
	 * @return 更新成功返回true，否则false
	 */
	public boolean updateSimpleInfo(CustomerPO po);
	
	/**
	 * 更新客户的VIP信息
	 * @param po
	 * @return 更新成功返回true，否则返回false
	 */ 
	public boolean updateVIP(CustomerPO po);
	
	/**
	 * 更新客户的信用值
	 * @param customerID
	 * @param delta 有正有负
	 * @return 更新成功返回true，否则false
	 */
	public boolean updateCredit(int customerID, int delta);
	
	/**
	 * 获得客户的信用变化的记录
	 * @param customerID
	 * @return 信用变化记录的列表
	 */
	public List<CreditPO> getCreditList(int customerID);

	/**添加一条信用变化记录
	 * @param po
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addCreditRecord(CreditPO po);
	
}
