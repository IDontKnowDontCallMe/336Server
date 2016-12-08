package data.promotiondata;

import java.util.Map;

import businesslogic.promotionbl.HotelPromotionType;

public interface HotelPromotionDao {


	public Map<Integer, Map<String, HotelPromotionType>> getAllHotelPromotion();

	public Map<String, HotelPromotionType> getHotelPromotionObject(int hotelID);
	
	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionType newHotelPromotion);
	
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType);
}
