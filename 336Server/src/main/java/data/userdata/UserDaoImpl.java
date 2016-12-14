package data.userdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import data.databaseutility.ConnectionFactory;
import po.CustomerPO;
import po.HotelPO;
import po.WebMarketerPO;

public class UserDaoImpl implements UserDao{

	private Connection con;
	private PreparedStatement pps;
	
	@Override
	public List<CustomerPO> getCustomerList() {
		// TODO Auto-generated method stub
		List<CustomerPO> list = new ArrayList<CustomerPO>();
		
		try{
			
			String sql = "SELECT * FROM customertable ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				CustomerPO po = toCustomerPO(res);
				list.add(po);
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
		
		
		return list;
	}

	@Override
	public List<HotelPO> getHotelList() {
		// TODO Auto-generated method stub
		List<HotelPO> list = new ArrayList<HotelPO>();
		
		try{
			
			String sql = "SELECT * FROM hoteltable ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				HotelPO po = toHotelPO(res);
				list.add(po);
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
		
		return list;
	}

	@Override
	public boolean insertWebMarketer(WebMarketerPO po) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			String sql = "INSERT INTO marketertable SET marketerID =?, name = ?, phoneNumber = ? ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			pps.setInt(1, po.getWebMarketerID());
			pps.setString(2, po.getName());
			pps.setString(3, po.getPhoneNumber());
			
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
	public List<WebMarketerPO> getWebMarketerList() {
		// TODO Auto-generated method stub
		List<WebMarketerPO> list = new ArrayList<WebMarketerPO>();
		
		try{
			
			String sql = "SELECT * FROM marketertable ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();
			
			while(res.next()){
				WebMarketerPO po = toWebMarketerPO(res);
				list.add(po);
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
		
		return list;
	}

	@Override
	public boolean updateWebMarketer(WebMarketerPO po) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			String sql = "UPDATE marketertable SET  name = ?, phoneNumber = ? WHERE marketerID = ? ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			pps.setString(1, po.getName());
			pps.setString(2, po.getPhoneNumber());
			pps.setInt(3, po.getWebMarketerID());
			
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
	public String getPassword(int userID) {
		// TODO Auto-generated method stub
		String result = null;
		try{
			String sql = "SELECT * FROM logintable WHERE userID = ? ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			pps.setInt(1, userID);
			
			ResultSet res = pps.executeQuery();
			
			if(res.next()){
				result =  res.getString(2);
				res.close();
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
	public int insertCustomer(CustomerPO customerPO) {
		// TODO Auto-generated method stub
		int customerID = -1;
		try{
			String sql = "SELECT count(*) FROM customertable ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			
			ResultSet res = pps.executeQuery();
			
			
			if(res.next()){
				customerID = res.getInt(1) + 100000001;
			}
			else {
				res.close();
				pps.close();
				con.close();
				return -1;
			}
			
			String sql2 = "INSERT INTO customertable SET customerID = ?, customerName =?, phoneNumber = ?, isBirthVIP =?, isCompanyVIP = ?, credit = 0 ";
			pps = con.prepareStatement(sql2);
			pps.setInt(1, customerID);
			pps.setString(2, customerPO.getName());
			pps.setString(3, customerPO.getPhoneNumber());
			pps.setBoolean(4, false);
			pps.setBoolean(5, false);
			
			if(pps.executeUpdate()>0){
				res.close();
				pps.close();
				con.close();
				return customerID;
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
		
		return -1;
	}

	@Override
	public boolean addUser(int userID, String password) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			String sql = "INSERT INTO logintable SET userID =?, password = ?, isOnline = ? ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			pps.setInt(1, userID);
			pps.setString(2, password);
			pps.setBoolean(3, false);
			
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
	
	private WebMarketerPO toWebMarketerPO(ResultSet res){
		try{
			int id = res.getInt(1);
			String name = res.getString(2);
			String phoneNumber = res.getString(3);
			
			WebMarketerPO webMarketerPO = new WebMarketerPO(id, name, phoneNumber);
			return webMarketerPO;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	
	
}
