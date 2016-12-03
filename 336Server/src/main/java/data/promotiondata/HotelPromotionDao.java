package data.promotiondata;

import java.util.List;

import po.HotelPromotionPO;

public interface HotelPromotionDao {

	public List<HotelPromotionPO> getHotelPromotionObject(int hotelID);
	
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType) ;

	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionPO po);
}
