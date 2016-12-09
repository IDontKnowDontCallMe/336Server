package businesslogic.promotionbl;

import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class CompanyPromotion extends HotelPromotionType {

	private static final long serialVersionUID = 1L;
	private double discount;
	private String requiredCompany;
	private int hotelID;
	
	public CompanyPromotion(HotelPromotionVO hotelPromotionVO) {
		super(hotelPromotionVO);
		// TODO Auto-generated constructor stub
		this.discount = hotelPromotionVO.discount;
		this.requiredCompany = hotelPromotionVO.companyName;
		this.hotelID = hotelPromotionVO.hotelID;
	}

	@Override
	public double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO) {
		if(!customerVO.isCompanyVIP || !customerVO.companyName.equals(requiredCompany)){
			return 1.0;
		}
		else {
			return discount;
		}
	}

	@Override
	public HotelPromotionVO toHotelPromotionVO() {
		// TODO Auto-generated method stub
		return new HotelPromotionVO(hotelID, "合作企业促销策略", null, null, requiredCompany	, -1, discount);
	}

}
