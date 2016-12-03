package dataservice.promotiondataservice;

import java.util.List;

import po.HotelPromotionPO;
import po.LevelPO;
import po.WebPromotionPO;

public interface PromotionDataService {

	public List<WebPromotionPO> getWebPromotionObject();
	
	public boolean writeWebPromotionObject(WebPromotionPO po);
	
	public boolean deleteWebPromotionObject(String PromotionType);
	
	public LevelPO getLevelObject();
	
	public boolean updateLevelObject(LevelPO po);
	
	public List<HotelPromotionPO> getHotelPromotionObject(int hotelID);
	
	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionPO po);
	
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType);

	
}
