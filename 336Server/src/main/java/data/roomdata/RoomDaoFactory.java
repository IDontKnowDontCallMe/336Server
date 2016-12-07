package data.roomdata;

public class RoomDaoFactory {
	
	private static RoomDao roomTypeDao;
	
	public static RoomDao getRoomTypeDao(){
		if(roomTypeDao==null){
			roomTypeDao = new RoomDaoImpl();
		}
		return roomTypeDao;
	}

}
