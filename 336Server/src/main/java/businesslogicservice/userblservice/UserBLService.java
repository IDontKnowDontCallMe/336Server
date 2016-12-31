package businesslogicservice.userblservice;


import java.util.List;

import vo.CustomerVO;
import vo.HotelVO;
import vo.WebMarketerVO;

/**
 * UserBL模块提供的接口
 * @author szz
 *
 */
public interface UserBLService {

	/**
	 * 获得网站的客户列表
	 * @return 客户列表
	 */
	public List<CustomerVO> getCustomerList() ;
	
	public boolean addCustomer(CustomerVO customervo);
	
	/**
	 * 修改客户的基本信息
	 * @param customerVO
	 * @return 修改成功返回true，否则false
	 */
	public boolean updateCustomer(CustomerVO customerVO) ;
	
	/**
	 * 获得网站的酒店列表
	 * @return 网站的酒店列表
	 */
	public List<HotelVO> getHotelList() ;
	
	/**
	 * 向系统添加一个新酒店
	 * @param hotelVO
	 * @return 添加成功返回true，否则false
	 */
	public boolean addHotel(HotelVO hotelVO) ;
	
	/**
	 * 更新酒店工作人员信息
	 * @param hotelVO
	 * @return 更新成功返回true，否则false
	 */
	public boolean updateHotelWorker(HotelVO hotelVO) ;
	
	/**
	 * 过的网站营销人员列表
	 * @return 网站营销人员列表
	 */
	public List<WebMarketerVO> getWebMarketerList();
	
	/**
	 * 向系统添加一个新的网站营销人员账户
	 * @param webMarketerVO
	 * @return 添加成功返回true，否则false
	 */
	public boolean addWebMarketer(WebMarketerVO webMarketerVO) ;
	
	/**
	 * 修改客户的信用值，用于信用充值
	 * @param customerID
	 * @param delta 有正负值之分
	 * @return 修改成功返回true，否则false
	 */
	public boolean updateCreditOfCustomer(int customerID, int delta);
	
	/**
	 * 登录系统
	 * @param userID
	 * @param password
	 * @return 客户登陆成功返回“customer”；酒店工作人员登陆成功返回“hotelWorker”；网站营销人员登录成功返回“webMarketer”；
	 * 网站管理人员登陆成功返回“webManager”；该账户已登录返回“has logined”；无该账户返回“NOT_FOUND”
	 */
	public String login(int userID, String password) ;
	
	/**
	 * 告知系统该ID已登录正在被使用，系统收到后会做相应记录
	 * @param userID
	 */
	public void survivalConfirm(int userID);
	
	/**
	 * 注册新客户
	 * @param customerName
	 * @param phoneNumber
	 * @param password
	 * @return 注册所得的账户ID，以后登录需要用的；-1说明注册失败
	 */
	public int register(String customerName, String phoneNumber, String password) ;
	
	/**
	 * 更改用户密码
	 * @param userID
	 * @param newPassword
	 */
	public void changePassword(int userID, String newPassword);

	/**
	 * 修改网站营销人员基本信息
	 * @param vo
	 * @return 修改成功返回true，否则false
	 */
	public boolean updateWebMarketer(WebMarketerVO vo) ;

	
}
