package data.roomdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

import data.databaseutility.ConnectionFactory;
import po.RoomPO;

public class RoomDaoImpl implements RoomDao{

	private Connection con;
	private PreparedStatement pps;
	
	
	@Override
	public boolean addRoomType(RoomPO po) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO  roomtable SET roomID = ?, hotelID = ?, roomName = ?, price = ?, peopleNum = ?, introduction = ?, roomNum = ? ";
			pps = con.prepareStatement(sql);
			pps.setInt(1, po.getRoomID());
			pps.setInt(2, po.getHotelID());
			pps.setString(3, po.getRoomName());
			pps.setInt(4, po.getPrice());
			pps.setInt(5, po.getPeopleNum());
			pps.setString(6, po.getIntroduction());
			pps.setInt(7, po.getRoomNum());
			
			if(pps.executeUpdate()>0){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Map<Integer, RoomPO> getRoomTypeList(int hotelID) {
		// TODO Auto-generated method stub
		LinkedHashMap<Integer, RoomPO> map = new LinkedHashMap<Integer,RoomPO>();
		
		try{
			
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM roomtable WHERE hotelID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				RoomPO po = toRoomPO(res);
				map.put(po.getRoomID(), po);
			}
			return map;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public RoomPO getRoomPO(int roomID) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM roomtable WHERE roomID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, roomID);
			
			ResultSet res = pps.executeQuery();
			
			if(res.next()){
				RoomPO po = toRoomPO(res);
				return po;
			}
			else{
				return null;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	private RoomPO toRoomPO(ResultSet res){
		try{
			int roomID = res.getInt(1);
			int hotelID = res.getInt(2);
			String roomName = res.getString(3);
			int price = res.getInt(4);
			int peopleNum = res.getInt(5);
			String introduction = res.getString(6);
			int roomNum = res.getInt(7);
			
			RoomPO roomPO = new RoomPO(roomID, hotelID, roomName, price, peopleNum, introduction, roomNum);
			return roomPO;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
