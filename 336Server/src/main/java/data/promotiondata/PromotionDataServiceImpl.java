package data.promotiondata;

import java.util.List;
import dataservice.promotiondataservice.PromotionDataService;
import po.HotelPromotionPO;
import po.LevelPO;
import po.WebPromotionPO;

public class PromotionDataServiceImpl implements PromotionDataService{
	
	private HotelPromotionDao hotelPromotionDao;
	private WebPromotionDao webPromotionDao;
	
	public PromotionDataServiceImpl() {
		// TODO Auto-generated constructor stub
		hotelPromotionDao = PromotionDaoFactory.getHotelPromotionDaoInstance();
		webPromotionDao = PromotionDaoFactory.getWebPromotionDaoInstance();
	}

	@Override
	public List<WebPromotionPO> getWebPromotionObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeWebPromotionObject(WebPromotionPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteWebPromotionObject(String promotionType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LevelPO getLevelObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateLevelObject(LevelPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HotelPromotionPO> getHotelPromotionObject(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType) {
		// TODO Auto-generated method stub
		return false;
	}


}
