package businesslogicservice.roomblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import po.RoomPO;
import vo.RoomVO;

public interface RoomBLService {
	
	public boolean addRoomType(int hotelID, RoomVO roomVO);
	
	public boolean updateRoomType(int hotelID, RoomVO roomVO) ;
	
	public boolean deleteRoomType(int roomID) ;
	
	public List<RoomVO> getRoomTypeList(int hotelID) ;
	
	public RoomVO getRoomType(int roomID) ;
	
	//public boolean isValid(int roomID, Date start, Date end, int num) throws RemoteException;
	
	//public boolean updateUsage(int roomID, Date start, Date end, int num) throws RemoteException;
}
