package data.hoteldata;

import java.util.List;

import dataservice.hoteldataservice.HotelDataService;
import po.CommentPO;
import po.HotelPO;


public class HotelDataServiceImpl implements HotelDataService{

	private HotelDao hotelDao;
	
	@Override
	public List<HotelPO> getHotelListOfArea(String city, String businessCircle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelPO getHotelInfo(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateHotel(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addComment(CommentPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CommentPO> getCommentListOf(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
