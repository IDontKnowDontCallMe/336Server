package data.roomdata;

import java.util.HashMap;
import java.util.Map;

import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;

public class RoomDataService_Stub implements RoomDataService{

	private Map<Integer, RoomPO> map;
	
	public RoomDataService_Stub() {
		// TODO Auto-generated constructor stub
		map = new HashMap<Integer, RoomPO>();
		RoomPO roomPO = new RoomPO(300000001, 200000001, "Stub房间", 150, 1, "只是一个stub房间用于测试", 2);
		map.put(roomPO.getRoomID(), roomPO);
	}
	
	@Override
	public boolean addRoomType(RoomPO po) {
		// TODO Auto-generated method stub
		map.put(po.getRoomID(), po);
		return true;
	}

	@Override
	public Map<Integer, RoomPO> getRoomTypeList(int hotelID) {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public RoomPO getRoomPO(int roomID) {
		// TODO Auto-generated method stub
		return map.get(300000001);
	}

	@Override
	public int getRoomNum() {
		// TODO Auto-generated method stub
		return map.size();
	}

}
