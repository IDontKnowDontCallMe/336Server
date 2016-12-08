package businesslogic.promotionbl;

import java.io.Serializable;
import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.WebPromotionVO;

public abstract class WebPromotionType implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public WebPromotionType(WebPromotionVO webPromotionVO) {}

	public abstract double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO);
	
	public abstract WebPromotionVO toWebPromotionVO();
}
