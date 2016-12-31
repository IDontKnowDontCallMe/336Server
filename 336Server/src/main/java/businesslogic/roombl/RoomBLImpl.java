package businesslogic.roombl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import factory.DataFactory;
import po.RoomPO;
import vo.RoomVO;

public class RoomBLImpl {

	private Map<Integer, Map<Integer, RoomPO>> roomListCache;
	
	public RoomBLImpl() {
		// TODO Auto-generated constructor stub
		roomListCache = new LinkedHashMap<Integer,Map<Integer, RoomPO>>(20, (float) 0.75, false);
	}
	
	
	public boolean addRoomType(int hotelID,RoomVO roomVO){
		int roomID = DataFactory.getRoomDataService().getRoomNum();
		RoomPO po = new RoomPO(roomID, hotelID, roomVO.roomName, roomVO.price, roomVO.maxNumOfPeople, roomVO.introduction, roomVO.numOfRoom);
		
		if(DataFactory.getRoomDataService().addRoomType(po)){
			if(roomListCache.containsKey(hotelID)){
				roomListCache.get(hotelID).put(po.getRoomID(), po);
			}
			return true;
		}
		else {
			return false;
		}
	};
	
	public List<RoomVO> getRoomTypeList(int hotelID) {
		if(!roomListCache.containsKey(hotelID)){
			loadToRoomListCache(hotelID);
		}
		
		return getRoomVOsByPOs(roomListCache.get(hotelID));
	};
	
	public RoomVO getRoomType(int roomID){
		RoomPO roomPO = DataFactory.getRoomDataService().getRoomPO(roomID);
		
		if(roomPO==null) return null;
		
		RoomVO roomVO = new RoomVO(roomPO.getRoomID(), roomPO.getRoomName(), roomPO.getPrice(), roomPO.getRoomNum(), roomPO.getIntroduction(), roomPO.getPeopleNum());
		return roomVO;
		
	};
	
	private void loadToRoomListCache(int hotelID){
		Map<Integer, RoomPO> map = DataFactory.getRoomDataService().getRoomTypeList(hotelID);
		roomListCache.put(hotelID, map);
	}
	
	private List<RoomVO> getRoomVOsByPOs(Map<Integer, RoomPO> map){
		List<RoomVO> list = new ArrayList<RoomVO>();
		if(map.size()>0){
			for(Entry<Integer, RoomPO> entry: map.entrySet()){
				RoomVO vo = new RoomVO(entry.getValue().getRoomID(), entry.getValue().getRoomName(), entry.getValue().getPrice(), entry.getValue().getRoomNum(), entry.getValue().getIntroduction(), entry.getValue().getPeopleNum());
				list.add(vo);
			}
		}
		return list;
	}
	
	//----------------------------------------------------------------------
	
	public boolean updateRoomType(int hotelID, RoomVO roomVO){
		/***
		RoomPO roomPO = new RoomPO();
		roomPO.setRoomName(roomVO.roomName);
		roomPO.setNumofRooms(roomVO.numOfRoom);
		roomPO.setprice(roomVO.price);
		return DataFactory.getRoomDataService().updateRoomType(hotelID, roomPO);
		
		//需求没有暂时不实现了
		***/
		return false;
		
		
	};
	
	public boolean deleteRoomType(int roomID) {
		/****
		return DataFactory.getRoomDataService().deleteRoomPO(roomID);
		
		//需求没有暂时不实现了
		***/
		return false;
	};
	
	
}
