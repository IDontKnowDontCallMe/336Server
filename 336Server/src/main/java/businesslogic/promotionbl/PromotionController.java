package businesslogic.promotionbl;

import java.util.List;

import businesslogicservice.promotionblservice.PromotionBLService;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.LevelVO;
import vo.WebPromotionVO;

public class PromotionController implements PromotionBLService{
	
	private PromotionBLImpl promotionBLImpl;
	
	public PromotionController() {
		// TODO Auto-generated constructor stub
		promotionBLImpl = new PromotionBLImpl();
	}

	@Override
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) {
		// TODO Auto-generated method stub
		return promotionBLImpl.getHotelPromotionList(hotelID);
	}

	@Override
	public boolean addHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		return promotionBLImpl.addHotelPromotion(vo);
	}

	@Override
	public boolean updateHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		return promotionBLImpl.updateHotelPromotion(vo);
	}

	@Override
	public boolean deleteHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		return promotionBLImpl.deleteHotelPromotion(vo);
	}

	@Override
	public List<WebPromotionVO> getWebPromotionList() {
		// TODO Auto-generated method stub
		return promotionBLImpl.getWebPromotionList();
	}

	@Override
	public boolean addWebPromotion(WebPromotionVO vo) {
		// TODO Auto-generated method stub
		return promotionBLImpl.addWebPromotion(vo);
	}

	@Override
	public boolean updateWebPromotion(WebPromotionVO vo) {
		// TODO Auto-generated method stub
		return promotionBLImpl.updateWebPromotion(vo);
	}

	@Override
	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO) {
		// TODO Auto-generated method stub
		return promotionBLImpl.deleteWebPromotion(webPromotionVO);
	}

	@Override
	public int calculateLevel(int credit) {
		// TODO Auto-generated method stub
		return promotionBLImpl.calculateLevel(credit);
	}

	@Override
	public boolean updateLevelMethod(LevelVO levelVO) {
		// TODO Auto-generated method stub
		return promotionBLImpl.updateLevelMethod(levelVO);
	}

	@Override
	public int calculateOrder(CalculationConditionVO calculationConditionVO, CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return promotionBLImpl.calculateOrder(calculationConditionVO, customerVO);
	}

	@Override
	public boolean updateLevelPromotion(LevelVO levelVO) {
		// TODO Auto-generated method stub
		return promotionBLImpl.updateLevelPromotion(levelVO);
	}

	@Override
	public LevelVO getLevelMethod() {
		// TODO Auto-generated method stub
		return promotionBLImpl.getLevelMethod();
	}

	@Override
	public LevelVO getLevelPromotion() {
		// TODO Auto-generated method stub
		return promotionBLImpl.getLevelPromotion();
	}

}
