package data.hoteldata;

import java.util.List;
import java.util.Map;

import po.CommentPO;
import po.HotelPO;

public interface HotelDao {

	public Map<Integer,HotelPO> getHotelListOfArea(String city, String businessCircle);
	
	public HotelPO getHotelInfo(int hotelID);
	
	public boolean updateWorker(HotelPO hotelPO);
	
	public boolean updateSimpleHotelInfo(HotelPO hotelPO);
	
	public boolean addComment(CommentPO po);
	
	public List<CommentPO> getCommentListOf(int hotelID);
	
}
