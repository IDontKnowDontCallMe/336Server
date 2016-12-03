package data.promotiondata;

import java.util.List;

import po.LevelPO;
import po.WebPromotionPO;

public interface WebPromotionDao {

	public List<WebPromotionPO> getWebPromotionObject();
	
	public boolean writeWebPromotionObject(WebPromotionPO po);
	
	public boolean deleteWebPromotionObject(String promotionType) ;
	
	public LevelPO getLevelObject();
	
	public boolean updateLevelObject(LevelPO po);
	
}
