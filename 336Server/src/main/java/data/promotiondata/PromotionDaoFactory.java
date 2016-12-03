package data.promotiondata;

public class PromotionDaoFactory {
	
	private static HotelPromotionDao hotelPromotionDao;
	private static WebPromotionDao webPromotionDao;
	
	public static HotelPromotionDao getHotelPromotionDaoInstance(){
		if(hotelPromotionDao==null){
			hotelPromotionDao = new HotelPromotionDaoImpl();
		}
		return hotelPromotionDao;
	}
	
	public static WebPromotionDao getWebPromotionDaoInstance(){
		if(webPromotionDao==null){
			webPromotionDao = new WebPromotionDaoImpl();
		}
		
		return webPromotionDao;
	}

}
