package businesslogic.roombl;

import java.util.ArrayList;
import java.util.List;

import businesslogicservice.roomblservice.RoomBLService;
import vo.RoomVO;

public class RoomBLService_Stub implements RoomBLService{
	
	private List<RoomVO> roomVOList;
	
	public RoomBLService_Stub() {
		// TODO Auto-generated constructor stub
		roomVOList = new ArrayList<RoomVO>();
		RoomVO roomVO = new RoomVO(300000001, "Stub房间", 150, 2, "Stub之用", 1);
		roomVOList.add(roomVO);
	}

	@Override
	public boolean addRoomType(int hotelID, RoomVO roomVO) {
		// TODO Auto-generated method stub
		System.out.println("add room");
		return true;
	}

	@Override
	public List<RoomVO> getRoomTypeList(int hotelID) {
		// TODO Auto-generated method stub
		return roomVOList;
	}

	@Override
	public RoomVO getRoomType(int roomID) {
		// TODO Auto-generated method stub
		return roomVOList.get(0);
	}

}
