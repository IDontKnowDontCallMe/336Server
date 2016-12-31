package dataservice.promotiondataservice;

import java.util.Map;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.LevelPromotionType;
import businesslogic.promotionbl.WebPromotionType;
import businesslogic.promotionbl.HotelPromotionType;

/**
 * PromotionData模块的接口
 * @author szs
 *
 */
public interface PromotionDataService {
	
	/**
	 * @return 网站的促销策略的map，key为促销策略的类型
	 */
	public Map<String, WebPromotionType> getAllWebPromotionObject();
	
	/**
	 * 存储一个网站促销策略；若之前存在一个同类型的促销策略，该策略将被新策略替换
	 * @param newWebPromotion
	 * @return 存储成功返回true，否则返回false
	 */
	public boolean writeWebPromotionObject(WebPromotionType newWebPromotion);
	
	/**
	 * 删除一个网站促销策略
	 * @param promotionType “特定时间促销策略”；“特定商圈促销策略”
	 * @return 删除成功返回true，否则false
	 */
	public boolean deleteWebPromotionObject(String promotionType);
	
	
	/**
	 * 获得所有酒店的所有促销策略
	 * @return 所有酒店的促销策略的map，key为hotelID
	 */
	public Map<Integer, Map<String, HotelPromotionType>> getAllHotelPromotion();
	
	/**
	 * 获得一个酒店的所有促销策略
	 * @return 一个酒店的促销策略的map，key为促销策略类型
	 */
	public Map<String, HotelPromotionType> getHotelPromotionObject(int hotelID);
	
	/**
	 * 存储一个酒店促销策略；若之前存在一个同类型的促销策略，该策略将被新策略替换
	 * @param newWebPromotion
	 * @return 存储成功返回true，否则返回false
	 */
	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionType newHotelPromotion);
	
	/**
	 * 删除一个酒店促销策略
	 * @param promotionType “特定时间促销策略”；“预订多间促销策略”；“客户生日促销策略”；“合作企业促销策略”
	 * @return 删除成功返回true，否则false
	 */
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType);
	
	
	/**
	 * @return 网站的等级计算方法
	 */
	public LevelMethod getLevelMethodObject();
	
	/**
	 * 更新网站的等级计算方法
	 * @param newLevelMethod
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean updateLevelMethodObject(LevelMethod newLevelMethod);
	
	/**
	 * @return 网站的等级促销策略
	 */
	public LevelPromotionType getLevelPromotionType();
	
	/**
	 * 更新网站的等级促销策略
	 * @param newLevelPromotionType
	 * @return 更新成功返回true，否则返回false
	 */
	public boolean updateLevelPromotionType(LevelPromotionType newLevelPromotionType);
	

	
}
