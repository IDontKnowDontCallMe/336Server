package businesslogic.promotionbl;

import vo.HotelPromotionVO;

public class HotelPromotionFactory {

	public static HotelPromotionType creatHotelPromotion(HotelPromotionVO hotelPromotionVO){
		switch (hotelPromotionVO.promotionType) {
		case "预订多间促销策略":
			return new RoomPromotion(hotelPromotionVO);
			
			
		case "特定时间促销策略":
			return new HotelTimePromotion(hotelPromotionVO);
			
			
		case "合作企业促销策略":
			return new CompanyPromotion(hotelPromotionVO);
			
			
		case "客户生日促销策略":
			return new BirthdayPromotion(hotelPromotionVO);
			
		default:
			return null;
		}
	}
	
}
