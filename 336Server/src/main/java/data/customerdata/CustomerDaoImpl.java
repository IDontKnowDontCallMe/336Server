package data.customerdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import data.databaseutility.ConnectionFactory;
import po.CreditPO;
import po.CustomerPO;


public class CustomerDaoImpl implements CustomerDao{

	private Connection con;
	private PreparedStatement pps;
	
	@Override
	public CustomerPO getInfo(int customerID) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM customertable WHERE customerID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, customerID);

			
			ResultSet res = pps.executeQuery();
			
			if(res.next()){
				CustomerPO po = toCustomerPO(res);
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
	public boolean updateSimpleInfo(CustomerPO po) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE customertable SET customerName = ?, phoneNumber = ? WHERE customerID = ?";
			pps = con.prepareStatement(sql);
			pps.setString(1, po.getName());
			pps.setString(2, po.getPhoneNumber());
			pps.setInt(3, po.getID());

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
	public boolean updateVIP(CustomerPO po) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql;
			
			if(po.isBirthVIP()){
				sql = "UPDATE customertable SET isBirthVIP = ?, birthday = ? WHERE customerID = ?";
				pps = con.prepareStatement(sql);
				pps.setBoolean(1, po.isBirthVIP());
				pps.setString(2, po.getVIPbirthday().toString());
				pps.setInt(3, po.getID());
			}
			else if(po.isCompanyVIP()){
				sql = "UPDATE customertable SET isCompanyVIP = ?, companyName = ? WHERE customerID = ?";
				pps = con.prepareStatement(sql);
				pps.setBoolean(1, po.isCompanyVIP());
				pps.setString(2, po.getVIPcompany());
				pps.setInt(3, po.getID());
			}
			else {
				return false;
			}
			
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
	public boolean updateCredit(int customerID, int delta) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE customertable SET credit = credit + ? WHERE customerID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, delta);
			pps.setInt(2, customerID);
			
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
	public List<CreditPO> getCreditList(int customerID) {
		// TODO Auto-generated method stub
		List<CreditPO> list = new ArrayList<CreditPO>();
		try{

			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM credittable WHERE customerID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, customerID);
			
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				CreditPO po = toCreditPO(res);
				list.add(po);
			}
			
			return list;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addCreditRecord(CreditPO po) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql1 = "SELECT credit FROM customertble WHERE customerID = ? ";
			pps = con.prepareStatement(sql1);
			pps.setInt(1, po.getCustomerID());
			ResultSet res = pps.executeQuery();
			
			int initCredit = 0;
			if(res.next()){
				initCredit = res.getInt(1);
			}
			else{
				return false;
			}
			
			String sql2 = "INSERT INTO  credittable SET customerID = ?, producingTime = ?, orderID = ?, action = ?, creditDelta = ? creditResult = ? ";
			pps = con.prepareStatement(sql2);
			pps.setInt(1, po.getCustomerID());
			pps.setString(2, po.getTime().format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss")));
			pps.setString(3, po.getOrderID());
			pps.setString(4, po.getActionType());
			pps.setInt(5, po.getDelta());
			pps.setInt(6, initCredit + po.getDelta());
			
			pps.executeUpdate() ;
			
			String sql3 ="UPDATE customertable SET credit = ? WHERE customerID = ? ";
			pps = con.prepareStatement(sql3);
			pps.setInt(1, initCredit + po.getDelta());
			pps.setInt(2, po.getCustomerID());
			pps.executeUpdate();
			
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	private CustomerPO toCustomerPO(ResultSet res){
		try{
			int customerID = res.getInt(1);
			String customerName = res.getString(2);
			String phoneNumber = res.getString(3);
			boolean isBirthVIP = res.getBoolean(4);
			LocalDate birthDay = res.getString(5) == null? null: LocalDate.parse(res.getString(5));
			boolean isCompanyVIP = res.getBoolean(6);
			String companyName = res.getString(7)==null? null: res.getString(7);
			int credit = res.getInt(8);
			
			CustomerPO customerPO = new CustomerPO(customerName, phoneNumber, customerID, birthDay, companyName, credit, isBirthVIP	, isCompanyVIP);
			
			return customerPO;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	private CreditPO toCreditPO(ResultSet res){
		try{
			int customerID = res.getInt(1);
			LocalDateTime producingDateTime = LocalDateTime.from(res.getTimestamp(2).toInstant());
			String orderID = String.valueOf(res.getInt(3));
			String action = res.getString(4);
			int delta = res.getInt(5);
			int result = res.getInt(6);
			
			CreditPO creditPO = new CreditPO(customerID, producingDateTime, orderID, action, delta, result);
			
			return creditPO;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
