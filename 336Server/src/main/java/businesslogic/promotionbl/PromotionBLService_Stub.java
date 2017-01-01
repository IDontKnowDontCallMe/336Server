package businesslogic.promotionbl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.promotionblservice.PromotionBLService;
import vo.CalculationConditionVO;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.LevelVO;
import vo.WebPromotionVO;

public class PromotionBLService_Stub implements PromotionBLService{

	private List<HotelPromotionVO> hotelPromotionVOList;
	private List<WebPromotionVO> WebPromotionVOList;
	private List<LevelVO> levelVOList;
	
	public PromotionBLService_Stub() {
		// TODO Auto-generated constructor stub
		hotelPromotionVOList = new ArrayList<HotelPromotionVO>();
		HotelPromotionVO hotelPromotionVO = new HotelPromotionVO(200000001, "Stub type", LocalDate.of(2016, 10, 6), LocalDate.of(2016, 12, 30), null, 3, 0.95);
		hotelPromotionVOList.add(hotelPromotionVO);
		
		WebPromotionVOList = new ArrayList<>();
		WebPromotionVO webPromotionVO = new WebPromotionVO("Stub type", LocalDate.of(2016, 10, 6), LocalDate.of(2016, 12, 30), "南京", "栖霞区", 0.95);
		WebPromotionVOList.add(webPromotionVO);
		
		levelVOList = new ArrayList<>();
		LevelVO levelVO = new LevelVO(1000, 15, 0.05);
		levelVOList.add(levelVO);
	}
	
	@Override
	public List<HotelPromotionVO> getHotelPromotionList(int hotelID) {
		// TODO Auto-generated method stub
		return hotelPromotionVOList;
	}

	@Override
	public boolean addHotelPromotion(HotelPromotionVO hotelPromotionVO) {
		// TODO Auto-generated method stub
		System.out.print("add hotel promotion");
		return true;
	}

	@Override
	public boolean updateHotelPromotion(HotelPromotionVO hotelPromotionVO) {
		// TODO Auto-generated method stub
		System.out.print("update hotel promotion");
		return true;
	}

	@Override
	public boolean deleteHotelPromotion(HotelPromotionVO vo) {
		// TODO Auto-generated method stub
		System.out.print("delete hotel promotion");
		return true;
	}

	@Override
	public List<WebPromotionVO> getWebPromotionList() {
		// TODO Auto-generated method stub
		return WebPromotionVOList;
	}

	@Override
	public boolean addWebPromotion(WebPromotionVO webPromotionVO) {
		// TODO Auto-generated method stub
		System.out.print("add web promotion");
		return true;
	}

	@Override
	public boolean updateWebPromotion(WebPromotionVO webPromotionVO) {
		// TODO Auto-generated method stub
		System.out.print("update web promotion");
		return true;
	}

	@Override
	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO) {
		// TODO Auto-generated method stub
		System.out.print("delete web promotion");
		return true;
	}

	@Override
	public boolean updateLevelMethod(LevelVO levelVO) {
		// TODO Auto-generated method stub
		System.out.print("update level method");
		return true;
	}

	@Override
	public LevelVO getLevelMethod() {
		// TODO Auto-generated method stub
		return levelVOList.get(0);
	}

	@Override
	public LevelVO getLevelPromotion() {
		// TODO Auto-generated method stub
		return levelVOList.get(0);
	}

	@Override
	public boolean updateLevelPromotion(LevelVO levelVO) {
		// TODO Auto-generated method stub
		System.out.print("update level promotion");
		return true;
	}

	@Override
	public int calculateOrder(CalculationConditionVO calculationConditionVO, CustomerVO customerVO) {
		// TODO Auto-generated method stub
		return calculationConditionVO.roomPrice * calculationConditionVO.roomNum ;
	}

	@Override
	public int calculateLevel(int credit) {
		// TODO Auto-generated method stub
		return credit/1000;
	}

}
