package businesslogicservice.roomblservice;

import java.util.List;
import vo.RoomVO;


/**
 * RoomBL模块提供的接口
 * @author tx
 *
 */
public interface RoomBLService {
	
	/**
	 * 向一个酒店添加新房型
	 * @param hotelID
	 * @param roomVO
	 * @return 添加成功返回true，否则false
	 */
	public boolean addRoomType(int hotelID, RoomVO roomVO);
	
	public boolean updateRoomType(int hotelID, RoomVO roomVO) ;
	
	public boolean deleteRoomType(int roomID) ;
	
	/**
	 * 获得酒店的房型列表
	 * @param hotelID
	 * @return 酒店的房型列表
	 */
	public List<RoomVO> getRoomTypeList(int hotelID) ;
	
	/**获得房型的信息
	 * @param roomID
	 * @return 房型的信息
	 */
	public RoomVO getRoomType(int roomID) ;
	
	//public boolean isValid(int roomID, Date start, Date end, int num) throws RemoteException;
	
	//public boolean updateUsage(int roomID, Date start, Date end, int num) throws RemoteException;
}
