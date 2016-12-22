package businesslogicservice.promotionblservice;

import java.util.List;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.LevelVO;
import vo.WebPromotionVO;

/**
 * PromotionBL模块提供的接口
 * @author szs
 *
 */
public interface PromotionBLService{
	
	
	/**
	 * 获得该酒店的促销策略列表
	 * @param hotelID
	 * @return 酒店的促销策略列表
	 */
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) ;
	
	/**
	 * 添加一个酒店促销策略
	 * @param hotelPromotionVO
	 * @return 添加成功返回true，否则false
	 */
	public boolean addHotelPromotion(HotelPromotionVO hotelPromotionVO) ;
	
	/**
	 * 更新一个酒店促销策略
	 * @param hotelPromotionVO
	 * @return 更新成功返回true，否则false
	 */
	public boolean updateHotelPromotion(HotelPromotionVO hotelPromotionVO);
	
	/**
	 * 删除一个酒店促销策略
	 * @param hotelPromotionVO
	 * @return 删除成功返回true，否则false
	 */
	public boolean deleteHotelPromotion(HotelPromotionVO vo);
	
	/**
	 * 获得网站的促销策略列表
	 * @return 网站的促销策略列表
	 */ 
	public List<WebPromotionVO> getWebPromotionList() ;
	
	/**
	 * 添加一个网站促销策略
	 * @param webPromotionVO
	 * @return 添加成功返回true，否则false
	 */
	public boolean addWebPromotion(WebPromotionVO webPromotionVO) ;
	
	/**
	 * 更新一个网站促销策略
	 * @param webPromotionVO
	 * @return 更新成功返回true，否则false
	 */
	public boolean updateWebPromotion(WebPromotionVO webPromotionVO) ;
	
	/**
	 * 删除一个网站促销策略
	 * @param webPromotionVO
	 * @return 删除成功返回true，否则false
	 */
	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO) ;
	
	/**
	 * 更新网站等级计算方法
	 * @param levelVO
	 * @return 更新成功返回true，否则false
	 */
	public boolean updateLevelMethod(LevelVO levelVO);
	
	/**
	 * 获得网站等级计算方法
	 * @return 网站等级计算方法
	 */
	public LevelVO getLevelMethod();
	
	/**
	 * 获得网站等级促销策略
	 * @return 网站等级促销策略
	 */
	public LevelVO getLevelPromotion();
	
	/**
	 * 更新网站等级促销策略
	 * @param levelVO
	 * @return 更新成功返回true，否则false
	 */
	public boolean updateLevelPromotion(LevelVO levelVO);
	
	/**
	 * 计算订单总价
	 * @param calculationConditionVO
	 * @param customerVO
	 * @return 订单总价
	 */
	public int calculateOrder(CalculationConditionVO calculationConditionVO, CustomerVO customerVO);
	
	/**
	 * 计算等级
	 * @param credit
	 * @return 该信用值对应的等级
	 */
	public int calculateLevel(int credit);

}
