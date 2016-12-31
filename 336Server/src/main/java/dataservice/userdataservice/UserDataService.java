package dataservice.userdataservice;

import java.util.List;

import po.CustomerPO;
import po.HotelPO;
import po.WebMarketerPO;

/**
 * UserData模块的接口
 * @author szs
 *
 */
public interface UserDataService {

	/**
	 * @return 包含所有客户记录的列表
	 */
	public List<CustomerPO> getCustomerList();

	/**
	 * @return 包含所有酒店记录的列表
	 */
	public List<HotelPO> getHotelList();

	/**
	 * 添加一条网站营销人员的记录
	 * @param WebMarketerPO
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean insertWebMarketer(WebMarketerPO po);

	/**
	 * @return 包含所有网站营销人员记录的列表
	 */
	public List<WebMarketerPO> getWebMarketerList();
	
	/**
	 * 更新一个网站营销人员的信息
	 * @param WebMarketerPO
	 * @return 更新成功返回true，否则false
	 */
	public boolean updateWebMarketer(WebMarketerPO po);
	
	/**
	 * @param userID
	 * @return 对应该id的密文处理过的密码
	 */
	public String getPassword(int userID);
	
	/**
	 * 添加一个新用户
	 * @param userID
	 * @param password
	 * @return 添加成功返回true，否则false
	 */
	public boolean addUser(int userID, String password);
	
	/**
	 * 更改一个账户的密码
	 * @param userID
	 * @param newPassword
	 */
	public void updatePassworder(int userID, String newPassword);
	
	/**
	 * 添加新客户
	 * @param customerPO
	 * @return 添加成功返回true，否则返回false
	 */
	public int insertCustomer(CustomerPO customerPO);

}
