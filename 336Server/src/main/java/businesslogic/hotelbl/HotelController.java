package businesslogic.hotelbl;

import java.util.List;

import businesslogic.userbl.HotelInfoUpdater;
import businesslogicservice.hotelblservice.HotelBLService;
import businesslogicservice.hotelblservice.OrderForC_H_Service;
import factory.DataFactory;
import po.HotelPO;
import vo.AreaVO;
import vo.CommentVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.SearchConditionVO;

public class HotelController implements HotelBLService, HotelInfoUpdater{

	private HotelSearchingImpl hotelSearchingImpl;
	private HotelDetailInfoImpl hotelDetailInfoImpl;
	private HotelCommentImpl hotelCommentImpl;
	private HotelInfoUpdaterImpl hotelInfoUpdaterImpl;
	
	public HotelController() {
		// TODO Auto-generated constructor stub
		hotelDetailInfoImpl = new HotelDetailInfoImpl();
		hotelSearchingImpl = new HotelSearchingImpl();
		hotelCommentImpl = new HotelCommentImpl();
		hotelInfoUpdaterImpl = new HotelInfoUpdaterImpl();
	}
	
	
	@Override
	public List<HotelVO> getHotelVOsOfArea(AreaVO areaVO, int customerID) {
		// TODO Auto-generated method stub
		return hotelSearchingImpl.getHotelVOsOfArea(areaVO, customerID);
	}

	@Override
	public List<HotelVO> search(AreaVO areaVO, SearchConditionVO searchConditionVO) {
		// TODO Auto-generated method stub
		return hotelSearchingImpl.search(areaVO, searchConditionVO);
	}

	@Override
	public List<HotelVO> sort(int customerID, String sortType) {
		// TODO Auto-generated method stub
		return hotelSearchingImpl.sort(customerID, sortType);
	}

	@Override
	public List<RoomVO> getRoomListOfHotel(int hotelID) {
		// TODO Auto-generated method stub
		return hotelDetailInfoImpl.getRoomListOfHotel(hotelID);
	}

	@Override
	public List<OrderVO> getOrderListOfHotel(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		return hotelDetailInfoImpl.getOrderListOfHotel(hotelID, customerID);
	}

	@Override
	public List<CommentVO> getCommentList(int hotelID) {
		// TODO Auto-generated method stub
		return hotelDetailInfoImpl.getCommentList(hotelID);
	}


	@Override
	public List<HotelVO> getBookedHotelList(int customerID) {
		// TODO Auto-generated method stub
		return hotelSearchingImpl.getBookedHotelList(customerID);
	}

	@Override
	public boolean updateSimpleHotelInfo(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		boolean updateTag = hotelInfoUpdaterImpl.updateSimpleInfo(hotelVO);
		
		if(updateTag){
			hotelSearchingImpl.updateAreaCache(hotelVO);
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean addComment(CommentVO commentVO) {
		// TODO Auto-generated method stub
		return hotelCommentImpl.addComment(commentVO);
	}

	@Override
	public HotelVO getHotelInfo(int hotelID) {
		// TODO Auto-generated method stub
		return hotelDetailInfoImpl.getHotelInfo(hotelID);
	}
	
	@Override
	public boolean updateWorkerInfo(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		
		boolean updateTag = hotelInfoUpdaterImpl.updateWorkerInfo(hotelVO);
		
		if(updateTag){
			hotelSearchingImpl.updateAreaCache(hotelVO);
			return true;
		}
		else{
			return false;
		}
		
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
