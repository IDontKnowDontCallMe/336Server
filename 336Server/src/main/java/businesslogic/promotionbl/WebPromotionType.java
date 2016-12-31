package businesslogic.promotionbl;

import java.io.Serializable;
import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.WebPromotionVO;

/**
 * 网站促销策略的接口
 * @author sjl
 *
 */
public abstract class WebPromotionType implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public WebPromotionType(WebPromotionVO webPromotionVO) {}

	/**
	 * @param calculationVO
	 * @param checkInDate
	 * @param customerVO
	 * @return 折后价格
	 */
	public abstract double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO);
	
	public abstract WebPromotionVO toWebPromotionVO();
}
