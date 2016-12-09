package businesslogic.promotionbl;

import java.time.LocalDate;
import java.util.List;

import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.LevelVO;
import vo.WebPromotionVO;

public class PromotionBLImpl {

	private HotelPromotionImpl hotelPromotionImpl;
	private WebPromotionImpl webPromotionImpl;
	private LevelImpl levelImpl;
	
	public PromotionBLImpl(){
		hotelPromotionImpl = new HotelPromotionImpl();
		webPromotionImpl = new WebPromotionImpl();
		levelImpl = new LevelImpl();
	}

	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) {
		return hotelPromotionImpl.getHotelPromotionList(hotelID);
	}

	public boolean addHotelPromotion(HotelPromotionVO vo) {
		return hotelPromotionImpl.addHotelPromotion(vo);
	}

	public boolean updateHotelPromotion(HotelPromotionVO vo) {
		return hotelPromotionImpl.updateHotelPromotion(vo);
	}

	public boolean deleteHotelPromotion(HotelPromotionVO vo) {
		return hotelPromotionImpl.deleteHotelPromotion(vo);
	}

	public List<WebPromotionVO> getWebPromotionList() {
		return webPromotionImpl.getWebPromotionList();
	}

	public boolean addWebPromotion(WebPromotionVO vo) {
		return webPromotionImpl.addWebPromotion(vo);
	}

	public boolean updateWebPromotion(WebPromotionVO vo) {
		return webPromotionImpl.updateWebPromotion(vo);
	}

	public boolean deleteWebPromotion(WebPromotionVO vo) {
		return webPromotionImpl.deleteWebPromotion(vo);
	}

	public int calculateOrder(CalculationConditionVO calculationVO, CustomerVO customerVO) {
		customerVO.level = levelImpl.calculateLevel(customerVO.credit);
		int price = calculationVO.roomPrice;
		int result = 0;
		for(LocalDate i = calculationVO.startDate; i.isBefore(calculationVO.endDate) ; i.plusDays(1)){
			double hotelDiscount = hotelPromotionImpl.getDiscount(calculationVO, i, customerVO);
			double webDiscount = webPromotionImpl.getDiscount(calculationVO, i, customerVO);
			double levelDiscount = levelImpl.getDiscount(calculationVO, i, customerVO);
			result += price * hotelDiscount * webDiscount * levelDiscount;
		}
		
		return result;
	}

	public int calculateLevel(int credit) {
		return levelImpl.calculateLevel(credit);
	}

	public boolean updateLevelMethod(LevelVO vo) {
		return levelImpl.updateLevelMethod(vo);
	}
	
	public boolean updateLevelPromotion(LevelVO vo){
		return levelImpl.updateLevelPromotion(vo);
	}
	
	public LevelVO getLevelMethod(){
		return levelImpl.getLevelMethod();
	}
	
	public LevelVO getLevelPromotion(){
		return levelImpl.getLevelPromotion();
	}
}
