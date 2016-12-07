package dataservice.hoteldataservice;

import java.util.List;
import java.util.Map;

import po.CommentPO;
import po.HotelPO;

public interface HotelDataService {
	
	public Map<Integer,HotelPO> getHotelListOfArea(String city, String businessCircle);
	
	public HotelPO getHotelInfo(int hotelID);
	
	public boolean updateWorker(HotelPO hotelPO);
	
	public boolean updateHotel(HotelPO hotelPO);
	
	public boolean addComment(CommentPO po);
	
	public List<CommentPO> getCommentListOf(int hotelID);
	
	public boolean addHotel(HotelPO hotelPO);
	
	public int getHotelNum();

}
