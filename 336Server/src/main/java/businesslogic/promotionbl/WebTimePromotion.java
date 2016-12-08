package businesslogic.promotionbl;

import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.WebPromotionVO;

public class WebTimePromotion extends WebPromotionType {
	
	private static final long serialVersionUID = 1L;
	private double discount;
	private LocalDate start;
	private LocalDate end;

	public WebTimePromotion(WebPromotionVO webPromotionVO) {
		super(webPromotionVO);
		this.start = webPromotionVO.startTime;
		this.end = webPromotionVO.endTime;
	}

	@Override
	public double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate,
			CustomerVO customerVO) {
		if(!LocalDate.now().isBefore(start) && !LocalDate.now().isAfter(end)){
			return discount;
			
		}
		else {
			return 1.0;
		}
	}

	@Override
	public WebPromotionVO toWebPromotionVO() {
		// TODO Auto-generated method stub
		return new WebPromotionVO("特定时间促销策略", start, end, null, null, discount);
	}
	
}
