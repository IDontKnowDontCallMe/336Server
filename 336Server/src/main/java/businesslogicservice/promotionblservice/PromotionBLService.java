package businesslogicservice.promotionblservice;

import java.util.List;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.LevelVO;
import vo.WebPromotionVO;

public interface PromotionBLService{
	
	
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) ;
	
	public boolean addHotelPromotion(HotelPromotionVO hotelPromotionVO) ;
	
	public boolean updateHotelPromotion(HotelPromotionVO hotelPromotionVO);
	
	public boolean deleteHotelPromotion(HotelPromotionVO vo);
	
	public List<WebPromotionVO> getWebPromotionList() ;
	
	public boolean addWebPromotion(WebPromotionVO webPromotionVO) ;
	
	public boolean updateWebPromotion(WebPromotionVO webPromotionVO) ;
	
	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO) ;
	
	public boolean updateLevelMethod(LevelVO levelVO);
	
	public LevelVO getLevelMethod();
	
	public LevelVO getLevelPromotion();
	
	public boolean updateLevelPromotion(LevelVO levelVO);
	
	public int calculateOrder(CalculationConditionVO calculationConditionVO, CustomerVO customerVO);
	
	public int calculateLevel(int credit);

}
