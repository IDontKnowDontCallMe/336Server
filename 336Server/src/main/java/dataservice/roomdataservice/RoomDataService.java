package dataservice.roomdataservice;

import java.util.Map;

import po.RoomPO;

public interface RoomDataService {
	
	public boolean addRoomType(RoomPO po);
	
	public Map<Integer, RoomPO> getRoomTypeList(int hotelID);
	
	public RoomPO getRoomPO(int roomID);

}
