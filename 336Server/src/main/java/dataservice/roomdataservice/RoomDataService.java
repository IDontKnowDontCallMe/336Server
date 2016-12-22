package dataservice.roomdataservice;

import java.util.Map;

import po.RoomPO;

/**
 * RoomData模块的接口
 * @author tx
 *
 */
public interface RoomDataService {
	
	/**
	 * 添加一个房型记录
	 * @param RoomPO
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addRoomType(RoomPO po);
	
	/**
	 * @param hotelID
	 * @return 该酒店的房型记录。key为roomID，value为房型记录信息
	 */
	public Map<Integer, RoomPO> getRoomTypeList(int hotelID);
	
	/**
	 * @param roomID
	 * @return 对应roomID的房型记录
	 */
	public RoomPO getRoomPO(int roomID);
	
	/**
	 * @return 房型记录的数量
	 */
	public int getRoomNum();

}
