package businesslogic.promotionbl;

import java.io.Serializable;
import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public abstract class HotelPromotionType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public HotelPromotionType(HotelPromotionVO hotelPromotionVO) {}

	public abstract double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO);
	
	public abstract HotelPromotionVO toHotelPromotionVO();
}
