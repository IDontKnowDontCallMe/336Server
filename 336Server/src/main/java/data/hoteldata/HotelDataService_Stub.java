package data.hoteldata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataservice.hoteldataservice.HotelDataService;
import po.CommentPO;
import po.HotelPO;

public class HotelDataService_Stub implements HotelDataService{

	private HotelPO hotelCase;
	private Map<Integer, HotelPO> areaMapCase;
	private List<CommentPO> commentList;
	
	public HotelDataService_Stub() {
		// TODO Auto-generated constructor stub
		hotelCase = new HotelPO(200000001, "Stub酒店", "南京", "栖霞区", "仙林大道", "只是一个stub", "无服务", "苏先生", "15800001111", 5, 5, -1, -1);
		
		areaMapCase = new HashMap<Integer, HotelPO>();
		areaMapCase.put(hotelCase.getHotelID(), hotelCase);
		
		commentList = new ArrayList<CommentPO>();
		CommentPO commentPO = new CommentPO(200000001, "Stub酒店", "Stub房间", "样例评价", 5, LocalDateTime.of(LocalDate.of(2016, 10, 10), LocalTime.of(10, 45)), 100000001);
		commentList.add(commentPO);
	}
	
	
	@Override
	public Map<Integer, HotelPO> getHotelListOfArea(String city, String businessCircle) {
		// TODO Auto-generated method stub
		return areaMapCase;
	}

	@Override
	public HotelPO getHotelInfo(int hotelID) {
		// TODO Auto-generated method stub
		return hotelCase;
	}

	@Override
	public boolean updateWorker(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		hotelCase.setWorkerName(hotelPO.getWorkerName());
		hotelCase.setPhoneNumber(hotelPO.getPhoneNumber());
		return true;
	}

	@Override
	public boolean updateHotel(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		hotelCase = hotelPO;
		return true;
	}

	@Override
	public boolean addComment(CommentPO po) {
		// TODO Auto-generated method stub
		commentList.add(po);
		return true;
	}

	@Override
	public List<CommentPO> getCommentListOf(int hotelID) {
		// TODO Auto-generated method stub
		return commentList;
	}

	@Override
	public boolean addHotel(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		areaMapCase.put(hotelPO.getHotelID(), hotelPO);
		return true;
	}

	@Override
	public int getHotelNum() {
		// TODO Auto-generated method stub
		return areaMapCase.size();
	}

	@Override
	public byte[] getHotelImage(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveHotelImage(int hotelID, byte[] imageDate) {
		// TODO Auto-generated method stub
		return false;
	}

}
