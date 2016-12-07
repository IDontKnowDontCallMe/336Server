package data.hoteldata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import data.databaseutility.ConnectionFactory;
import po.CommentPO;
import po.HotelPO;

public class HotelDaoImpl implements HotelDao{

	private Connection con;
	private PreparedStatement pps;
	
	@Override
	public Map<Integer,HotelPO> getHotelListOfArea(String city, String businessCircle) {
		// TODO Auto-generated method stub
		HashMap<Integer, HotelPO> result = new LinkedHashMap<Integer,HotelPO>();
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM hoteltable WHERE city = ? and businessCircle = ?";
			pps = con.prepareStatement(sql);
			pps.setString(1, city);
			pps.setString(2, businessCircle);
			
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				HotelPO po = toHotelPO(res);
				result.put(po.getHotelID(), po);
			}
			
			return result;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public HotelPO getHotelInfo(int hotelID) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM hoteltable WHERE hotelID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);

			
			ResultSet res = pps.executeQuery();
			
			if(res.next()){
				HotelPO po = toHotelPO(res);
				return po;
			}
			
			return null;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean updateSimpleHotelInfo(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE commenttable SET hotelName = ?, address = ?, introduction = ?, service = ? WHERE hotelID = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, hotelPO.getHotelName());
			pps.setString(2, hotelPO.getAddress());
			pps.setString(3, hotelPO.getIntroduction());
			pps.setString(4, hotelPO.getService());
			pps.setInt(5, hotelPO.getHotelID());
			
			return pps.executeUpdate() > 0;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean addComment(CommentPO po) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO commenttable SET hotelID = ?, hotelName = ?, roomName = ?, customerID = ?, comment = ?, score = ?, producingTime = ? ";
			pps = con.prepareStatement(sql);
			pps.setInt(1, po.getHotelID());
			pps.setString(2, po.getNameOfHotel());
			pps.setString(3, po.getNameOfRoom());
			pps.setInt(4, po.getCustomerID());
			pps.setString(5, po.getComment());
			pps.setDouble(6, po.getScore());
			pps.setString(7, po.getProducingDateTime().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss")));
			
			return pps.executeUpdate() > 0;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<CommentPO> getCommentListOf(int hotelID) {
		// TODO Auto-generated method stub
		List<CommentPO> result = new ArrayList<CommentPO>();
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM commenttable WHERE hotelID = ? ";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				CommentPO po = toCommentPO(res);
				result.add(po);
			}
			
			return result;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public boolean updateWorker(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE commenttable SET workerName = ? WHERE hotelID = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, hotelPO.getWorkerName());
			pps.setInt(2, hotelPO.getHotelID());
			
			return pps.executeUpdate() > 0;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean addHotel(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO hoteltable SET hotelID = ?, hotelName = ?, city = ?, businessCircle =?, workerName =?, phoneNumber =? ";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelPO.getHotelID());
			pps.setString(2, hotelPO.getHotelName());
			pps.setString(3, hotelPO.getCity());
			pps.setString(4, hotelPO.getBusinessCircle());
			pps.setString(5, hotelPO.getWorkerName());
			pps.setString(6, hotelPO.getPhoneNumber());
			
			
			return pps.executeUpdate() > 0;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public int getHotelNum(){
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT count(*)  FROM  hoteltable ";
			pps = con.prepareStatement(sql);
			
			ResultSet res = pps.executeQuery();
			
			if (res.next()) {
				int result = res.getInt(1);
				return result;
			}
			else {
				return -1;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	private HotelPO toHotelPO(ResultSet res){
		try {
		int hotelID = res.getInt(1);
		String hotelName = res.getString(2);
		String city = res.getString(3);
		String businessCircle = res.getString(4);
		String address = res.getString(5);
		String introduction = res.getString(6);
		String service = res.getString(7);
		String workerName = res.getString(8);
		String phoneNumber = res.getString(9);
		int score = res.getInt(10);
		double commentScore = res.getDouble(11);
		
		HotelPO po = new HotelPO(hotelID, hotelName, city, businessCircle, address, introduction, service, workerName, phoneNumber, score, commentScore, -1, -1);
		return po;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private CommentPO toCommentPO(ResultSet res){
		try{
			int hotelID = res.getInt(1);
			String nameOfHotel = res.getString(2);
			String nameOfRoom = res.getString(3);
			String comment = res.getString(5);
			double score = res.getDouble(6);
			LocalDateTime producingDateTime = res.getTimestamp(7) == null? null : LocalDateTime.ofInstant(res.getTimestamp(7).toInstant(), ZoneId.systemDefault());
			int customerID = res.getInt(4);
		
			CommentPO po = new CommentPO(hotelID, nameOfHotel, nameOfRoom, comment, score, producingDateTime, customerID);
			return po;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	

	

}
