package businesslogic.hotelbl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import businesslogicservice.hotelblservice.HotelBLService;
import po.CommentPO;
import po.RoomPO;
import vo.AreaVO;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;

public class HotelBLService_Stub implements HotelBLService{

	private List<HotelVO> hotelList;
	
	public HotelBLService_Stub() {
		// TODO Auto-generated constructor stub
		hotelList = new ArrayList<HotelVO>();	
		HotelVO hotelVO = new HotelVO(20000000, "Stub酒店", "南京", "栖霞区", "仙林大道", "Stub而已", "Stub服务", 5, 5, "Stub工作人员", "18800000000", 150, 2);
		hotelList.add(hotelVO);
	}
	
	@Override
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID) {
		// TODO Auto-generated method stub
		return hotelList;
	}

	@Override
	public List<HotelVO> search(AreaVO areaVO, SearchConditionVO searchCondionVO) {
		// TODO Auto-generated method stub
		System.out.println("search");
		return hotelList;
	}

	@Override
	public List<HotelVO> sort(int customerID, String sortType) {
		// TODO Auto-generated method stub
		System.out.println("sort");
		return hotelList;
	}

	@Override
	public List<RoomVO> getRoomListOfHotel(int hotelID) {
		// TODO Auto-generated method stub
		List<RoomVO> result = new ArrayList<>();
		RoomVO roomVO = new RoomVO(300000001, "Stub房间", 150, 1, "只是一个stub房间用于测试", 2);
		result.add(roomVO);
		return result;
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		List<OrderVO> list = new ArrayList<OrderVO>();
		OrderVO orderVO = new OrderVO(900000001, "Stub客户", 100000001, "1380000000", LocalDateTime.of(2016, 10, 10, 8, 2), "Stub酒店", "Stub房间", 1, 1, false, LocalDate.of(2016, 10, 10), LocalTime.of(12, 0), LocalDate.of(2016, 10, 11), 150, "已执行已离店", false);
		list.add(orderVO);
		return list;
	}

	@Override
	public List<HotelVO> getBookedHotelList(int customerID) {
		// TODO Auto-generated method stub
		return hotelList;
	}

	@Override
	public List<CommentVO> getCommentList(int hotelID) {
		// TODO Auto-generated method stub
		List<CommentVO> commentList = new ArrayList<CommentVO>();
		CommentVO commentVO = new CommentVO(200000001, "Stub酒店", "Stub房间", 100000001,"样例评价", 5, LocalDateTime.of(LocalDate.of(2016, 10, 10), LocalTime.of(10, 45)) );
		commentList.add(commentVO);
		return commentList;
	}

	@Override
	public boolean updateSimpleHotelInfo(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		System.out.println("update simple hotel");
		return true;
	}

	@Override
	public boolean addComment(CommentVO commentVO) {
		// TODO Auto-generated method stub
		System.out.println("add comment");
		return true;
	}

	@Override
	public HotelVO getHotelInfo(int hotelID) {
		// TODO Auto-generated method stub
		return hotelList.get(0);
	}

	@Override
	public int getHotelIDbyOrderID(int orderID) {
		// TODO Auto-generated method stub
		return 200000001;
	}

	@Override
	public boolean update(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public byte[] getHotelImage(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveHotelImage(int hotelID, byte[] imageData) {
		// TODO Auto-generated method stub
		return false;
	}

}
