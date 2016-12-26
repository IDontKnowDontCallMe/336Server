package businesslogic.promotionbl;

import java.io.Serializable;
import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.LevelVO;

/**
 * 等级促销策略的接口
 * @author sjl
 *
 */
public abstract class LevelPromotionType implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public LevelPromotionType(LevelVO levelVO) {}

	/**
	 * @param calculationVO
	 * @param checkInDate
	 * @param customerVO
	 * @return 折后价格
	 */
	public abstract double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO);
	
	public abstract LevelVO toLevelVO();
}
