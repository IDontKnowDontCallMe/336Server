package businesslogic.promotionbl;

import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class BirthdayPromotion extends HotelPromotionType {

	
	private static final long serialVersionUID = 1L;
	private double discount;
	private int hotelID;

	public BirthdayPromotion(HotelPromotionVO hotelPromotionVO) {
		// TODO Auto-generated constructor stub
		super(hotelPromotionVO);
		discount = hotelPromotionVO.discount;
		this.hotelID = hotelPromotionVO.hotelID;
	}
	
	@Override
	public double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO) {
		if(!customerVO.isBirthVIP || customerVO.birthday.getMonthValue()!=checkInDate.getMonthValue() || customerVO.birthday.getDayOfMonth()!=checkInDate.getDayOfMonth()){
			return 1.0;
		}
		else {
			return discount;
		}
	}

	@Override
	public HotelPromotionVO toHotelPromotionVO() {
		// TODO Auto-generated method stub
		return new HotelPromotionVO(hotelID, "客户生日促销策略", null, null, null, -1, discount);
	}

}
