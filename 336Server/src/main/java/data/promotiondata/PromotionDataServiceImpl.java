package data.promotiondata;


import java.util.Map;

import businesslogic.promotionbl.HotelPromotionType;
import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.LevelPromotionType;
import businesslogic.promotionbl.WebPromotionType;
import dataservice.promotiondataservice.PromotionDataService;


public class PromotionDataServiceImpl implements PromotionDataService{
	
	private HotelPromotionDao hotelPromotionDao;
	private WebPromotionDao webPromotionDao;
	
	public PromotionDataServiceImpl(){
		hotelPromotionDao = PromotionDaoFactory.getHotelPromotionDaoInstance();
		webPromotionDao = PromotionDaoFactory.getWebPromotionDaoInstance();
	}
	
	@Override
	public Map<String, WebPromotionType> getAllWebPromotionObject() {
		// TODO Auto-generated method stub
		return webPromotionDao.getAllWebPromotionObject();
	}
	@Override
	public boolean writeWebPromotionObject(WebPromotionType newWebPromotion) {
		// TODO Auto-generated method stub
		return webPromotionDao.writeWebPromotionObject(newWebPromotion);
	}
	@Override
	public boolean deleteWebPromotionObject(String PromotionType) {
		// TODO Auto-generated method stub
		return webPromotionDao.deleteWebPromotionObject(PromotionType);
	}
	@Override
	public Map<Integer, Map<String, HotelPromotionType>> getAllHotelPromotion() {
		// TODO Auto-generated method stub
		return hotelPromotionDao.getAllHotelPromotion();
	}
	@Override
	public Map<String, HotelPromotionType> getHotelPromotionObject(int hotelID) {
		// TODO Auto-generated method stub
		return hotelPromotionDao.getHotelPromotionObject(hotelID);
	}
	@Override
	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionType newHotelPromotion) {
		// TODO Auto-generated method stub
		return hotelPromotionDao.writeHotelPromotionObject(hotelID, newHotelPromotion);
	}
	@Override
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType) {
		// TODO Auto-generated method stub
		return hotelPromotionDao.deleteHotelPromotionObject(hotelID, promotionType);
	}
	@Override
	public LevelMethod getLevelMethodObject() {
		// TODO Auto-generated method stub
		return webPromotionDao.getLevelMethodObject();
	}
	@Override
	public boolean updateLevelMethodObject(LevelMethod newLevelMethod) {
		// TODO Auto-generated method stub
		return webPromotionDao.updateLevelMethodObject(newLevelMethod);
	}
	@Override
	public LevelPromotionType getLevelPromotionType() {
		// TODO Auto-generated method stub
		return webPromotionDao.getLevelPromotionType();
	}
	@Override
	public boolean updateLevelPromotionType(LevelPromotionType newLevelPromotionType) {
		// TODO Auto-generated method stub
		return webPromotionDao.updateLevelPromotionType(newLevelPromotionType);
	}
	
	


}
