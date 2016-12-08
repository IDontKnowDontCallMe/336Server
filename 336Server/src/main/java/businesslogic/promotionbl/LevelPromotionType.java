package businesslogic.promotionbl;

import java.io.Serializable;
import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.LevelVO;

public abstract class LevelPromotionType implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public LevelPromotionType(LevelVO levelVO) {}

	public abstract double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO);
	
	public abstract LevelVO toLevelVO();
}
