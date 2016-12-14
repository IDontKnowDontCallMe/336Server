package data.promotiondata;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import businesslogic.promotionbl.HotelPromotionType;
import data.databaseutility.ConnectionFactory;

public class HotelPromotionDaoImpl implements HotelPromotionDao {
	private Connection con = null;
	private PreparedStatement pps = null;
	
	
	@Override
	public Map<Integer, Map<String, HotelPromotionType>> getAllHotelPromotion() {
		// TODO Auto-generated method stub
		Map<Integer, Map<String, HotelPromotionType>> map = new LinkedHashMap<Integer, Map<String,HotelPromotionType>>();
		
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM hotelpromotiontable ";
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				int hotelID = res.getInt(1);
				if(!map.containsKey(hotelID)){
					Map<String, HotelPromotionType> temp = new LinkedHashMap<String,HotelPromotionType>();
					map.put(hotelID, temp);
				}
				
				String promotionType = res.getString(2);
				Blob blob = res.getBlob(3);
				
				InputStream is = blob.getBinaryStream();
			    ObjectInputStream ois = new ObjectInputStream(is);
				Object x = ois.readObject();
				HotelPromotionType hotelPromotionType = (HotelPromotionType)x;
				map.get(hotelID).put(promotionType, hotelPromotionType);
			}
			res.close();
			
		} catch (Exception e) {
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
		
		return map;
	}
	
	@Override
	public Map<String, HotelPromotionType> getHotelPromotionObject(int hotelID) {
		// TODO Auto-generated method stub
		Map<String, HotelPromotionType> map = new LinkedHashMap<String,HotelPromotionType>();
		
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM hotelpromotiontable WHERE hotelID = ? ";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				String promotionType = res.getString(2);
				Blob blob = res.getBlob(3);
				
				InputStream is = blob.getBinaryStream();
			    ObjectInputStream ois = new ObjectInputStream(is);
				Object x = ois.readObject();
				HotelPromotionType hotelPromotionType = (HotelPromotionType)x;
				map.put(promotionType, hotelPromotionType);
			}
			res.close();
			
		} catch (Exception e) {
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
		return map;
	}
	
	
	@Override
	public boolean writeHotelPromotionObject(int hotelID, HotelPromotionType newHotelPromotion) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO hotelpromotiontable SET hotelID = ?, promotionType = ?, promotionObject = ? ";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			pps.setString(2, newHotelPromotion.toHotelPromotionVO().promotionType);
			pps.setObject(3, (Object)newHotelPromotion);
			
			if (pps.executeUpdate()>0) {
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
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "DELETE FROM hotelpromotiontable WHERE hotelID = ? and promotionType = ? ";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			pps.setString(2, promotionType);
			
			
			if (pps.executeUpdate()>0) {
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

	
}
