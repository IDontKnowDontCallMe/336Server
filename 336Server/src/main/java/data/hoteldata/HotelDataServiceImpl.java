package data.hoteldata;

import java.util.List;
import java.util.Map;

import dataservice.hoteldataservice.HotelDataService;
import po.CommentPO;
import po.HotelPO;


public class HotelDataServiceImpl implements HotelDataService{

	private HotelDao hotelDao;
	
	public HotelDataServiceImpl() {
		// TODO Auto-generated constructor stub
		hotelDao = new HotelDaoImpl();
	}
	
	@Override
	public Map<Integer,HotelPO> getHotelListOfArea(String city, String businessCircle) {
		// TODO Auto-generated method stub
		return hotelDao.getHotelListOfArea(city, businessCircle);
	}

	@Override
	public HotelPO getHotelInfo(int hotelID) {
		// TODO Auto-generated method stub
		return hotelDao.getHotelInfo(hotelID);
	}

	@Override
	public boolean updateHotel(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		return hotelDao.updateSimpleHotelInfo(hotelPO);
	}

	@Override
	public boolean addComment(CommentPO po) {
		// TODO Auto-generated method stub
		return hotelDao.addComment(po);
	}

	@Override
	public List<CommentPO> getCommentListOf(int hotelID) {
		// TODO Auto-generated method stub
		return hotelDao.getCommentListOf(hotelID);
	}

	@Override
	public boolean updateWorker(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		return hotelDao.updateWorker(hotelPO);
	}

	@Override
	public boolean addHotel(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		return hotelDao.addHotel(hotelPO);
	}

	@Override
	public int getHotelNum() {
		// TODO Auto-generated method stub
		return hotelDao.getHotelNum();
	}

	@Override
	public byte[] getHotelImage(int hotelID) {
		// TODO Auto-generated method stub
		return hotelDao.getHotelImage(hotelID);
	}

	@Override
	public boolean saveHotelImage(int hotelID, byte[] imageDate) {
		// TODO Auto-generated method stub
		return hotelDao.saveHotelImage(hotelID, imageDate);
	}

	
	
	
	
	

}
