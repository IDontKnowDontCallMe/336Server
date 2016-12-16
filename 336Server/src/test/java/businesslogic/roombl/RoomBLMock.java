package businesslogic.roombl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import businesslogicservice.roomblservice.RoomBLService;
import vo.RoomVO;

public class RoomBLMock implements RoomBLService{
	
	private Map<Integer, List<RoomVO>> roomMap;
	
	public RoomBLMock() {
		// TODO Auto-generated constructor stub
		roomMap = new HashMap<Integer, List<RoomVO>>();
		List<RoomVO> roomList1 = new ArrayList<RoomVO>();
		List<RoomVO> roomList2 = new ArrayList<RoomVO>();
		List<RoomVO> roomList3 = new ArrayList<RoomVO>();
		
		RoomVO vo1 = new RoomVO(300000001, "单人房", 100, 2, "无", 1);
		RoomVO vo2 = new RoomVO(300000002, "双人房", 150, 2, "无", 2);
		RoomVO vo3 = new RoomVO(300000003, "三人房", 200, 2, "无", 3);
		roomList1.add(vo1);
		roomList1.add(vo2);
		roomList1.add(vo3);
		RoomVO vo4 = new RoomVO(300000004, "单人房", 150, 2, "无", 1);
		RoomVO vo5 = new RoomVO(300000005, "双人房", 250, 2, "无", 2);
		RoomVO vo6 = new RoomVO(300000006, "三人房", 350, 2, "无", 3);
		roomList2.add(vo4);
		roomList2.add(vo5);
		roomList2.add(vo6);
		RoomVO vo7 = new RoomVO(300000007, "单人房", 350, 2, "无", 1);
		RoomVO vo8 = new RoomVO(300000008, "双人房", 400, 2, "无", 2);
		RoomVO vo9 = new RoomVO(300000009, "三人房", 400, 2, "无", 3);
		roomList3.add(vo7);
		roomList3.add(vo8);
		roomList3.add(vo9);
		
		roomMap.put(200000001, roomList1);
		roomMap.put(200000002, roomList2);
		roomMap.put(200000003, roomList3);
	}

	@Override
	public boolean addRoomType(int hotelID, RoomVO roomVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateRoomType(int hotelID, RoomVO roomVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteRoomType(int roomID) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<RoomVO> getRoomTypeList(int hotelID) {
		// TODO Auto-generated method stub
		return roomMap.get(hotelID);
	}

	@Override
	public RoomVO getRoomType(int roomID) {
		// TODO Auto-generated method stub
		int index = roomID%100000000;
		 
		return roomMap.get(200000000+index).get((index-1)/3);
	}

}
