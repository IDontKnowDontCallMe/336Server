package businesslogic.promotionbl;

import java.time.LocalDate;

import factory.DataFactory;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.LevelVO;

public class LevelImpl {

	private LevelMethod presentLevelMethod;
	private LevelPromotionType presentLevelPromotion;
	
	public LevelImpl() {
		// TODO Auto-generated constructor stub
		presentLevelMethod = DataFactory.getPromotionDataService().getLevelMethodObject();
		presentLevelPromotion = DataFactory.getPromotionDataService().getLevelPromotionType();
	}
	
	public boolean updateLevelMethod(LevelVO levelVO) {
		LevelMethod newLevelMethod = new SimpleLevelMethod(levelVO);
		
		if(DataFactory.getPromotionDataService().updateLevelMethodObject(newLevelMethod)){
			presentLevelMethod = newLevelMethod;
			return true;
		}
		else {
			return false;
		}
	}

	public int calculateLevel(int credit) {
		if(presentLevelMethod!=null){
			return presentLevelMethod.calculateLevel(credit);
		}
		else {
			return -1;
		}
	}
	
	public boolean updateLevelPromotion(LevelVO levelVO){
		presentLevelPromotion = new SimpleLevelPromotion(levelVO);
		DataFactory.getPromotionDataService().updateLevelPromotionType(presentLevelPromotion);
		
		return true;
	}
	
	public double getDiscount(CalculationConditionVO calculationConditionVO , LocalDate checkInDate, CustomerVO customerVO){
		return presentLevelPromotion.calculateDiscount(calculationConditionVO, checkInDate, customerVO);
	}
}
