package data.promotiondata;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import businesslogic.promotionbl.HotelPromotionType;
import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.LevelPromotionType;
import businesslogic.promotionbl.WebPromotionType;
import data.databaseutility.ConnectionFactory;
import po.LevelPO;
import po.WebPromotionPO;

public class WebPromotionDaoImpl implements WebPromotionDao {

	private Connection con = null;
	private PreparedStatement pps = null;
	
	
	@Override
	public Map<String, WebPromotionType> getAllWebPromotionObject() {
		// TODO Auto-generated method stub
		Map<String, WebPromotionType> map = new LinkedHashMap<String,WebPromotionType>();
		
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM webpromotiontable ";
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				
				String promotionType = res.getString(2);
				Blob blob = res.getBlob(3);
				
				InputStream is = blob.getBinaryStream();
			    ObjectInputStream ois = new ObjectInputStream(is);
				Object x = ois.readObject();
				WebPromotionType webPromotionType = (WebPromotionType)x;
				map.put(promotionType, webPromotionType);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return map;
	}
	
	
	@Override
	public boolean writeWebPromotionObject(WebPromotionType newWebPromotion) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO webpromotiontable SET  promotionType = ?, promotionObject = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, newWebPromotion.toWebPromotionVO().promotionType);
			pps.setObject(2, (Object)newWebPromotion);
			
			if (pps.executeUpdate()>0) {
				return true;
			}
			else {
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
	public boolean deleteWebPromotionObject(String promotionType) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "DELETE FROM webpromotiontable WHERE  promotionType = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, promotionType);
			
			
			if (pps.executeUpdate()>0) {
				return true;
			}
			else {
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
	public LevelMethod getLevelMethodObject() {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM webpromotiontable WHERE promotionType = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, "等级方法");
			ResultSet res = pps.executeQuery();
			
			if(res.next()){
				
				Blob blob = res.getBlob(2);
				
				InputStream is = blob.getBinaryStream();
			    ObjectInputStream ois = new ObjectInputStream(is);
				Object x = ois.readObject();
				LevelMethod levelMethod = (LevelMethod)x;

				return levelMethod;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public boolean updateLevelMethodObject(LevelMethod newLevelMethod) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE webpromotiontable SET promotionObject = ? WHERE promotionType = ? ";
			pps = con.prepareStatement(sql);
			pps.setObject(1, (Object)newLevelMethod);
			pps.setString(2, "等级方法");
			
			if(pps.executeUpdate()>0){
				return true;
			}
			else {
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
	public LevelPromotionType getLevelPromotionType() {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM webpromotiontable WHERE promotionType = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, "等级促销策略");
			ResultSet res = pps.executeQuery();
			
			if(res.next()){
				
				Blob blob = res.getBlob(2);
				
				InputStream is = blob.getBinaryStream();
			    ObjectInputStream ois = new ObjectInputStream(is);
				Object x = ois.readObject();
				LevelPromotionType levelPromotionType = (LevelPromotionType)x;

				return levelPromotionType;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public boolean updateLevelPromotionType(LevelPromotionType newLevelPromotionType) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE webpromotiontable SET promotionObject = ? WHERE promotionType = ? ";
			pps = con.prepareStatement(sql);
			pps.setObject(1, (Object)newLevelPromotionType);
			pps.setString(2, "等级促销策略");
			
			if(pps.executeUpdate()>0){
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	
}
