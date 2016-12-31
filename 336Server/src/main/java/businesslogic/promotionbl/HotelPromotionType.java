package businesslogic.promotionbl;

import java.io.Serializable;
import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

/**
 * 酒店促销策略的接口
 * @author sjl
 *
 */
public abstract class HotelPromotionType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public HotelPromotionType(HotelPromotionVO hotelPromotionVO) {}

	/**
	 * @param calculationVO
	 * @param checkInDate
	 * @param customerVO
	 * @return 折后价格
	 */
	public abstract double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO);
	
	public abstract HotelPromotionVO toHotelPromotionVO();
}
