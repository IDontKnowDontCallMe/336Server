package data.roomdata;


import java.util.Map;

import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;

public class RoomDataServiceImpl implements RoomDataService{
	
	private RoomDao roomDao;
	
	public RoomDataServiceImpl() {
		// TODO Auto-generated constructor stub
		roomDao = RoomDaoFactory.getRoomTypeDao();
	}

	@Override
	public boolean addRoomType(RoomPO po) {
		// TODO Auto-generated method stub
		return roomDao.addRoomType(po);
	}

	@Override
	public Map<Integer, RoomPO> getRoomTypeList(int hotelID) {
		// TODO Auto-generated method stub
		return roomDao.getRoomTypeList(hotelID);
	}

	@Override
	public RoomPO getRoomPO(int roomID) {
		// TODO Auto-generated method stub
		return roomDao.getRoomPO(roomID);
	}

	@Override
	public int getRoomNum() {
		// TODO Auto-generated method stub
		return roomDao.getRoomNum();
	}

	
}
