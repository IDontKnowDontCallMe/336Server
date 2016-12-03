package businesslogic.promotionbl;

import data.factory.DataFactory;
import po.LevelPO;
import vo.LevelVO;

public class LevelImpl {

	public boolean updateLevel(LevelVO vo) {
		LevelPO po = new LevelPO(vo.creditDistance, vo.maxLevel, vo.discountDistance);
		DataFactory.getPromotionDataService().updateLevelObject(po);
		return true;
	}

	public int calculateLevel(int credit) {
		int creditDistance = DataFactory.getPromotionDataService().getLevelObject().getCreditDistance();
		int level = credit / creditDistance;
		return level;
	}

	public double getDiscount(int credit) {
		int level = calculateLevel(credit);
		double discount = 1 - level * DataFactory.getPromotionDataService().getLevelObject().getDiscountDistance();
		return discount;
	}
}
