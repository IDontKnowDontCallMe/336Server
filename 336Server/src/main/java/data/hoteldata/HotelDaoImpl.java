package data.hoteldata;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import data.databaseutility.ConnectionFactory;
import javafx.scene.image.Image;
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
			
			res.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				pps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	@Override
	public HotelPO getHotelInfo(int hotelID) {
		// TODO Auto-generated method stub
		HotelPO po = null;
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM hoteltable WHERE hotelID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);

			
			ResultSet res = pps.executeQuery();
			
			if(res.next()){
				po = toHotelPO(res);
			}
			
			res.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				pps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return po;
	}

	@Override
	public boolean updateSimpleHotelInfo(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE hoteltable SET hotelName = ?, address = ?, introduction = ?, service = ? , commentScore = ? WHERE hotelID = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, hotelPO.getHotelName());
			pps.setString(2, hotelPO.getAddress());
			pps.setString(3, hotelPO.getIntroduction());
			pps.setString(4, hotelPO.getService());
			pps.setDouble(5, hotelPO.getCommentScore());
			pps.setInt(6, hotelPO.getHotelID());
			
			if( pps.executeUpdate() > 0){
				result = true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				pps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}

	@Override
	public boolean addComment(CommentPO po) {
		// TODO Auto-generated method stub
		boolean result = false;
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
			pps.setTimestamp(7, Timestamp.valueOf(po.getProducingDateTime()));
			
			if(pps.executeUpdate() > 0){
				result = true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				pps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
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
			
			res.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				pps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	@Override
	public boolean updateWorker(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE hoteltable SET workerName = ? WHERE hotelID = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, hotelPO.getWorkerName());
			pps.setInt(2, hotelPO.getHotelID());
			
			if(pps.executeUpdate() > 0){
				result = true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				pps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	@Override
	public boolean addHotel(HotelPO hotelPO) {
		// TODO Auto-generated method stub
		boolean result = false;
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
			
			
			if(pps.executeUpdate() > 0){
				result = true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				pps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	@Override
	public int getHotelNum(){
		int result = -1;
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT count(*)  FROM  hoteltable ";
			pps = con.prepareStatement(sql);
			
			ResultSet res = pps.executeQuery();
			
			if (res.next()) {
				result = res.getInt(1);
			}
			
			res.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				pps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	@Override
	public byte[] getHotelImage(int hotelID) {
		// TODO Auto-generated method stub
		byte[] result = null;
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT *  FROM  hotelimagetable WHERE hotelID = ? ";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			
			ResultSet res = pps.executeQuery();
			
			if(res.next()){
				Blob blob = res.getBlob(2);
				
				InputStream is = blob.getBinaryStream();
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				int numBytesRead = 0;
				while ((numBytesRead = is.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
				}
				result = output.toByteArray();
				
				
			}
			
			res.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				pps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return result;
	}

	@Override
	public boolean saveHotelImage(int hotelID, byte[] imageDate) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE hotelimagetable SET  image = ? WHERE hotelID = ? ";
			pps = con.prepareStatement(sql);
			pps.setObject(1, (Object)imageDate);
			pps.setInt(2, hotelID);
			
			if (pps.executeUpdate()>0) {
				result = true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				pps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return result;	
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
