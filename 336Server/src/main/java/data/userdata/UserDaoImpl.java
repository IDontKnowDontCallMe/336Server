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
			
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
			
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean insertWebMarketer(WebMarketerPO po) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO marketertable SET marketerID =?, name = ?, phoneNumber = ? ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			pps.setInt(1, po.getWebMarketerID());
			pps.setString(2, po.getName());
			pps.setString(3, po.getPhoneNumber());
			
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
			
			return list;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean updateWebMarketer(WebMarketerPO po) {
		// TODO Auto-generated method stub
		try{
			String sql = "UPDATE marketertable SET  name = ?, phoneNumber = ? WHERE marketerID = ? ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			pps.setString(1, po.getName());
			pps.setString(2, po.getPhoneNumber());
			pps.setInt(3, po.getWebMarketerID());
			
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
	public String getPassword(int userID) {
		// TODO Auto-generated method stub
		try{
			String sql = "SELECT * FROM logintable WHERE userID = ? ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			pps.setInt(1, userID);
			
			ResultSet res = pps.executeQuery();
			
			if(res.next()){
				return res.getString(2);
			}
			else{
				return "NOT_FOUND";
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addUser(int userID, String password) {
		// TODO Auto-generated method stub
		try{
			String sql = "INSERT INTO logintable SET userID =?, password = ?, isOnline = ? ";
			con = ConnectionFactory.getDatabaseConnectionInstance();
			pps = con.prepareStatement(sql);
			pps.setInt(1, userID);
			pps.setString(2, password);
			pps.setBoolean(3, false);
			
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
