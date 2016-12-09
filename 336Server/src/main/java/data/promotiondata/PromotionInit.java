package data.promotiondata;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import businesslogic.promotionbl.LevelMethod;
import businesslogic.promotionbl.SimpleLevelMethod;
import businesslogic.promotionbl.SimpleLevelPromotion;
import businesslogic.promotionbl.WebPromotionFactory;
import businesslogic.promotionbl.WebPromotionType;
import data.databaseutility.ConnectionFactory;
import vo.LevelVO;
import vo.WebPromotionVO;

public class PromotionInit {

	public static void main(String[] args){
		
		WebPromotionDaoImpl webPromotionDaoImpl = new WebPromotionDaoImpl();
		
		LevelMethod levelMethod = webPromotionDaoImpl.getLevelMethodObject();
		
		int level = levelMethod.calculateLevel(2500);
		
		System.out.print(level);
		
		/******
		try{
			LevelVO levelVO = new LevelVO(1000, 15, -1);
			SimpleLevelMethod simpleLevelMethod = new SimpleLevelMethod(levelVO);
			
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO webpromotiontable SET  promotionObject = ?, promotionType = ? ";
			pps = con.prepareStatement(sql);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
			ObjectOutputStream out = null; 
		    try { 
		      out = new ObjectOutputStream(baos); 
		      out.writeObject(simpleLevelMethod);    
		    } catch (IOException e) { 
		      e.printStackTrace();
		    }finally{ 
		      try { 
		        out.close(); 
		      } catch (IOException e) { 
		        e.printStackTrace();
		      } 
		    } 
			
			pps.setObject(1, baos.toByteArray());
			pps.setString(2, "等级方法");
			System.out.print(pps.executeUpdate());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		******/
		
		
		
	}
	
}
