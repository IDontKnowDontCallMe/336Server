package data.hoteldata;

import java.util.List;

import po.CommentPO;
import po.HotelPO;

public interface HotelDao {

	public List<HotelPO> getHotelListOfArea(String city, String businessCircle);
	
	public HotelPO getHotelInfo(int hotelID);
	
	public boolean updateSimpleHotelInfo(HotelPO hotelPO);
	
	public boolean addComment(CommentPO po);
	
	public List<CommentPO> getCommentListOf(int hotelID);
	
}
