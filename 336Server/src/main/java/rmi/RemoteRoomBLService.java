package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vo.RoomVO;

public interface RemoteRoomBLService extends Remote{
	public boolean addRoomType(int hotelID, RoomVO roomVO) throws RemoteException;
	
	public List<RoomVO> getRoomTypeList(int hotelID) throws RemoteException;
	
	public RoomVO getRoomType(int roomID) throws RemoteException;
	
}
