package data.promotiondata;

import java.util.Map;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.LevelPromotionType;
import businesslogic.promotionbl.WebPromotionType;


public interface WebPromotionDao {


	public Map<String, WebPromotionType> getAllWebPromotionObject();
	
	public boolean writeWebPromotionObject(WebPromotionType newWebPromotion);
	
	public boolean deleteWebPromotionObject(String PromotionType);
	
	public LevelMethod getLevelMethodObject() ;
	
	public boolean updateLevelMethodObject(LevelMethod newLevelMethod);
	
	public LevelPromotionType getLevelPromotionType();
	
	public boolean updateLevelPromotionType(LevelPromotionType newLevelPromotionType);
	
}
