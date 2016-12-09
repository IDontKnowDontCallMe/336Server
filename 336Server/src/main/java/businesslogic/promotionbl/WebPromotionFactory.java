package businesslogic.promotionbl;

import vo.WebPromotionVO;

public class WebPromotionFactory {

	public static WebPromotionType creatWebPromotion(WebPromotionVO webPromotionVO){
		switch (webPromotionVO.promotionType) {
		
		case "特定时间促销策略":
			return new WebTimePromotion(webPromotionVO);
			
		case "特定商圈促销策略":
			return new AreaPromotion(webPromotionVO);
			
		default:
			return null;
		}
	}
	
}
