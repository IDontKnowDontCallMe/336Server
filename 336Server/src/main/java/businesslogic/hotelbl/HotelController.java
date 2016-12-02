package businesslogic.hotelbl;

import java.util.List;

import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.hotelblservice.OrderForC_H_Service;
import po.HotelPO;
import vo.AreaVO;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;

public class HotelController implements HotelBLService{

	private HotelSearchingImpl hotelSearchingImpl;
	private HotelDetailInfoImpl hotelDetailInfoImpl;
	private HotelInfoImpl hotelInfoImol;
	
	
	@Override
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> search(AreaVO areaVO, SearchConditionVO searchCondionVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> sort(int customerID, String sortType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomVO> getRoomListOfHotel(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentVO> getCommentList(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HotelVO> getBookedHotelList(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSimpleHotelInfo(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addComment(CommentVO commentVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HotelVO getHotelInfo(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	//-------------------------------------//maybe delet 
	
	@Override
	public boolean update(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean delete(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return true;
	}

}
