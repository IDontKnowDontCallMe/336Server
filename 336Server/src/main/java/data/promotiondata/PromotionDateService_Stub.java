package data.promotiondata;

import java.util.Map;

import businesslogic.promotionbl.HotelPromotionType;
import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.LevelPromotionType;
import businesslogic.promotionbl.WebPromotionType;
import dataservice.promotiondataservice.PromotionDataService;

public class PromotionDateService_Stub implements PromotionDataService{

	@Override
	public Map<String, WebPromotionType> getAllWebPromotionObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeWebPromotionObject(WebPromotionType newWebPromotion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWebPromotionObject(String promotionType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<Integer, Map<String, HotelPromotionType>> getAllHotelPromotion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, HotelPromotionType> getHotelPromotionObject(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionType newHotelPromotion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LevelMethod getLevelMethodObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateLevelMethodObject(LevelMethod newLevelMethod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LevelPromotionType getLevelPromotionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateLevelPromotionType(LevelPromotionType newLevelPromotionType) {
		// TODO Auto-generated method stub
		return false;
	}

}
