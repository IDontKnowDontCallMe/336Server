package businesslogic.promotionbl;

import java.time.LocalDate;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;

public class RoomPromotion extends HotelPromotionType {

	private static final long serialVersionUID = 1L;
	private double discount;
	private int minNum;
	private int hotelID;

	public RoomPromotion(HotelPromotionVO hotelPromotionVO) {
		super(hotelPromotionVO);
		this.discount = hotelPromotionVO.discount;
		this.minNum = hotelPromotionVO.minNum;
		this.hotelID = hotelPromotionVO.hotelID;
	}


	@Override
	public double calculateDiscount(CalculationConditionVO calculationVO, LocalDate checkInDate, CustomerVO customerVO) {
		if(calculationVO.roomNum>=minNum){
			return discount;
		}
		else {
			return 1.0;
		}
	}


	@Override
	public HotelPromotionVO toHotelPromotionVO() {
		// TODO Auto-generated method stub
		return new HotelPromotionVO(hotelID, "预订多间促销策略", null, null, null, minNum, discount);
	}

}
