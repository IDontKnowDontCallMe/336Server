package dataservice.promotiondataservice;

import java.util.Map;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.LevelPromotionType;
import businesslogic.promotionbl.WebPromotionType;
import businesslogic.promotionbl.HotelPromotionType;

public interface PromotionDataService {
	
	public Map<String, WebPromotionType> getAllWebPromotionObject();
	
	public boolean writeWebPromotionObject(WebPromotionType newWebPromotion);
	
	public boolean deleteWebPromotionObject(String promotionType);
	
	
	public Map<Integer, Map<String, HotelPromotionType>> getAllHotelPromotion();
	
	public Map<String, HotelPromotionType> getHotelPromotionObject(int hotelID);
	
	//若之前有同一类型的，先delete再write
	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionType newHotelPromotion);
	
	//若无删除对象，返回false
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType);
	
	
	public LevelMethod getLevelMethodObject();
	
	public boolean updateLevelMethodObject(LevelMethod newLevelMethod);
	
	public LevelPromotionType getLevelPromotionType();
	
	public boolean updateLevelPromotionType(LevelPromotionType newLevelPromotionType);
	

	
}
