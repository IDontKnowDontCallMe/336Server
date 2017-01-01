package businesslogic.roombl;

import java.util.List;
import businesslogicservice.roomblservice.RoomBLService;
import vo.RoomVO;

public class RoomController implements RoomBLService{
	RoomBLImpl roomblImpl = new RoomBLImpl();

	@Override
	public boolean addRoomType(int hotelID, RoomVO roomVO) {
		// TODO Auto-generated method stub
		return roomblImpl.addRoomType(hotelID, roomVO);
	}
	
	@Override
	public List<RoomVO> getRoomTypeList(int hotelID) {
		// TODO Auto-generated method stub
		return roomblImpl.getRoomTypeList(hotelID);
	}

	@Override
	public RoomVO getRoomType(int roomID) {
		// TODO Auto-generated method stub
		return roomblImpl.getRoomType(roomID);
	}

}
