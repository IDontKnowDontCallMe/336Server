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

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.LevelPromotionType;
import businesslogic.promotionbl.WebPromotionType;
import data.databaseutility.ConnectionFactory;

public class WebPromotionDaoImpl implements WebPromotionDao {

	private Connection con = null;
	private PreparedStatement pps = null;
	
	
	@Override
	public Map<String, WebPromotionType> getAllWebPromotionObject() {
		// TODO Auto-generated method stub
		Map<String, WebPromotionType> map = new LinkedHashMap<String,WebPromotionType>();
		
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM webpromotiontable WHERE promotionType != '等级促销策略' and promotionType != '等级方法' ";
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				System.out.println("web one");
				String promotionType = res.getString(1);
				Blob blob = res.getBlob(2);
				
				InputStream is = blob.getBinaryStream();
			    ObjectInputStream ois = new ObjectInputStream(is);
				Object x = ois.readObject();
				WebPromotionType webPromotionType = (WebPromotionType)x;
				map.put(promotionType, webPromotionType);
			}
			res.close();
			
		} catch (Exception e) {
			// TODO: handle exception
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
	public boolean writeWebPromotionObject(WebPromotionType newWebPromotion) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO webpromotiontable SET  promotionType = ?, promotionObject = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, newWebPromotion.toWebPromotionVO().promotionType);
			pps.setObject(2, (Object)newWebPromotion);
			
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
	
	
	@Override
	public boolean deleteWebPromotionObject(String promotionType) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "DELETE FROM webpromotiontable WHERE  promotionType = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, promotionType);
			
			
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
	public LevelMethod getLevelMethodObject() {
		// TODO Auto-generated method stub
		LevelMethod levelMethod = null;
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
				levelMethod = (LevelMethod)x;

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
		
		return levelMethod;
	}
	
	
	@Override
	public boolean updateLevelMethodObject(LevelMethod newLevelMethod) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE webpromotiontable SET promotionObject = ? WHERE promotionType = ? ";
			pps = con.prepareStatement(sql);
			pps.setObject(1, (Object)newLevelMethod);
			pps.setString(2, "等级方法");
			
			if(pps.executeUpdate()>0){
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
	public LevelPromotionType getLevelPromotionType() {
		// TODO Auto-generated method stub
		LevelPromotionType levelPromotionType = null;
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
				levelPromotionType = (LevelPromotionType)x;
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
		
		return levelPromotionType;
	}
	
	
	@Override
	public boolean updateLevelPromotionType(LevelPromotionType newLevelPromotionType) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE webpromotiontable SET promotionObject = ? WHERE promotionType = ? ";
			pps = con.prepareStatement(sql);
			pps.setObject(1, (Object)newLevelPromotionType);
			pps.setString(2, "等级促销策略");
			
			if(pps.executeUpdate()>0){
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
