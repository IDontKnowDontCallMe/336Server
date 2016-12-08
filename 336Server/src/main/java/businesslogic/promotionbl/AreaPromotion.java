package businesslogic.promotionbl;

import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.WebPromotionVO;

public class AreaPromotion extends WebPromotionType {

	private static final long serialVersionUID = 1L;
	private double discountDistance;
	private String city;
	private String businessCircle;
	
	public AreaPromotion(WebPromotionVO webPromotionVO) {
		// TODO Auto-generated constructor stub
		super(webPromotionVO);
		this.city = webPromotionVO.cityName;
		this.businessCircle = webPromotionVO.businessCircleName;
		this.discountDistance = webPromotionVO.discount;
	}

	@Override
	public double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO) {
		if(!city.equals(calculationVO.city) || !businessCircle.equals(calculationVO.businessCircle)){
			return 1.0;
		}
		
		return 1 - customerVO.level * discountDistance;
	}

	@Override
	public WebPromotionVO toWebPromotionVO() {
		// TODO Auto-generated method stub
		return new WebPromotionVO("特定商圈促销策略", null, null, city, businessCircle, discountDistance);
	}


}
