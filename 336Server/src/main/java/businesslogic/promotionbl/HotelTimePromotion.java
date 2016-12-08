package businesslogic.promotionbl;

import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class HotelTimePromotion extends HotelPromotionType {

	private static final long serialVersionUID = 1L;
	private double discount;
	private LocalDate start;
	private LocalDate end;
	private int hotelID;
	
	public HotelTimePromotion(HotelPromotionVO hotelPromotionVO) {
		// TODO Auto-generated constructor stub
		super(hotelPromotionVO);
		this.discount = hotelPromotionVO.discount;
		this.start = hotelPromotionVO.startTime;
		this.end = hotelPromotionVO.endTime;
		this.hotelID = hotelPromotionVO.hotelID;
	}

	@Override
	public double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO) {
		if(!checkInDate.isBefore(start) && !checkInDate.isAfter(end)){
			return discount;
		}
		else{
			return 1.0;
		}
	}

	@Override
	public HotelPromotionVO toHotelPromotionVO() {
		// TODO Auto-generated method stub
		return new HotelPromotionVO(hotelID, "特定时间促销策略", start, end, null, -1, discount);
	}

}
