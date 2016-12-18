package businesslogicservice.hotelblservice;

import java.util.List;

import vo.AreaVO;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;

public interface HotelBLService {

	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID);

	public List<HotelVO> search(AreaVO areaVO,SearchConditionVO searchCondionVO) ;
	
	public List<HotelVO> sort(int customerID, String sortType) ;
	
	public List<RoomVO>   getRoomListOfHotel(int hotelID) ;
	
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) ;
	
	public List<HotelVO> getBookedHotelList(int customerID) ;
	
	public List<CommentVO> getCommentList(int hotelID) ;
	
	public boolean updateSimpleHotelInfo(HotelVO hotelVO) ;
	
	public boolean addComment(CommentVO commentVO) ;

	public HotelVO getHotelInfo(int hotelID) ;
	
	public int getHotelIDbyOrderID(int orderID);

	public boolean update(HotelVO hotelVO) ;

	public boolean delete(HotelVO hotelVO);
	
	public byte[] getHotelImage(int hotelID);
	
	public boolean saveHotelImage(int hotelID, byte[] imageData);
	
}
