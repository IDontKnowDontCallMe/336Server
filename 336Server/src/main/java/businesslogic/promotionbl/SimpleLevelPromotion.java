package businesslogic.promotionbl;

import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.LevelVO;

public class SimpleLevelPromotion extends LevelPromotionType{

	private static final long serialVersionUID = 1L;
	private double discountDistance;
	private int creditDistance;
	private int maxLevel;
	
	public SimpleLevelPromotion(LevelVO levelVO) {
		super(levelVO);
		this.discountDistance = levelVO.discountDistance;
		this.creditDistance = levelVO.creditDistance;
		this.maxLevel = levelVO.maxLevel;
	}

	@Override
	public double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO) {
		if(customerVO.level < 1){
			return 1.0;
		}
		else {
			double off = discountDistance *0.01 * customerVO.level;
			return 1 - off;
		}
	}

	@Override
	public LevelVO toLevelVO() {
		// TODO Auto-generated method stub
		return new LevelVO(creditDistance, maxLevel, discountDistance);
	}

}
