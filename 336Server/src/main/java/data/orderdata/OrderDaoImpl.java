package data.orderdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import data.databaseutility.ConnectionFactory;
import po.OrderPO;

public class OrderDaoImpl implements OrderDao{
	
	private Connection con = null;
	private PreparedStatement pps = null;
	
	

	@Override
	public OrderPO getOrderByOrderID(int orderID) {
		// TODO Auto-generated method stub
		
		OrderPO po = null;
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM ordertable WHERE orderID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, orderID);
			ResultSet res =  pps.executeQuery();
			
			if(res.next()){
				
				po = toOrderPO(res);
			}
			
			pps.close();
			con.close();
			
			return po;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return null;
	}



	@Override
	public Map<Integer,OrderPO> getOrderByCustomerID(int customerID) {
		// TODO Auto-generated method stub
		Map<Integer,OrderPO> result = new LinkedHashMap<Integer,OrderPO>();
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM ordertable WHERE customerID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, customerID);
			ResultSet res =  pps.executeQuery();
			
			while(res.next()){
				
				OrderPO po = toOrderPO(res);
				result.put(po.getOrderID(), po);
			}
			
			pps.close();
			con.close();
			
			return result;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return result;
	}



	@Override
	public Map<Integer,OrderPO> getOrderByHotelID(int hotelID) {
		// TODO Auto-generated method stub
		Map<Integer,OrderPO> result = new LinkedHashMap<Integer,OrderPO>();
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM ordertable WHERE hotelID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			ResultSet res =  pps.executeQuery();
			
			while(res.next()){
				OrderPO po = toOrderPO(res);
				result.put(po.getOrderID(),po);
			}
			
			pps.close();
			con.close();
			
			return result;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return result;
	}



	@Override
	public List<OrderPO> getAbnormalOrdersOfToday() {
		// TODO Auto-generated method stub
		List<OrderPO> result = new ArrayList<OrderPO>();
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM ordertable WHERE checkInDate >= ? and checkInDate < ? and orderState = ?";
			String today = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
			String tomorrow = LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE);
			pps = con.prepareStatement(sql);
			pps.setString(1, today);
			pps.setString(2, tomorrow);
			pps.setString(3, "异常");
			ResultSet res =  pps.executeQuery();
			
			while(res.next()){
				OrderPO po = toOrderPO(res);
				result.add(po);
			}
			
			pps.close();
			con.close();
			
			return result;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return result;
	}



	@Override
	public boolean updateOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE ordertable  SET orderState = ?, revokingDateTime = ?, executingDateTime = ?, leavingDateTime = ?, hasComment = ? "
						+ "WHERE orderID = ? ";
			pps = con.prepareStatement(sql);
			pps.setString(1, orderPO.getOrderState());
			pps.setString(2, orderPO.getRevokingDateTime()==null? null: orderPO.getRevokingDateTime().toString());
			pps.setString(3, orderPO.getExecutingDateTime()==null? null: orderPO.getExecutingDateTime().toString());
			pps.setString(4, orderPO.getLeavingDateTime()==null? null: orderPO.getLeavingDateTime().toString());
			pps.setBoolean(5, orderPO.getHasComment());
			pps.setInt(6, orderPO.getOrderID());
			pps.executeUpdate();
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return false;
	}



	@Override
	public boolean insertOrder(OrderPO po) {
		// TODO Auto-generated method stub
		
		
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO ordertable  SET orderID = ?, customerName = ?, customerID = ?, producingDateTime = ?, hotelName = ?, hotelID = ?, "
					+ "roomName = ?, roomNum = ?, hasChildren = ?, peopleNum = ?, checkInDate = ?, latestArrivingTime = ?, checkOutDate = ?, "
					+ "total = ?, orderState = ?, revokingDateTime = ?, executingDateTime = ?, leavingDateTime = ?, hasComment = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, po.getOrderID());
			pps.setString(2, po.getCustomerName());
			pps.setInt(3, po.getCustomerID());
			pps.setTimestamp(4, Timestamp.valueOf(po.getProducingDateTime()));
			pps.setString(5, po.getHotelName());
			pps.setInt(6, po.getHotelID());
			pps.setString(7, po.getRoomName());
			pps.setInt(8, po.getRoomNum());
			pps.setBoolean(9, po.getHasChildren());
			pps.setInt(10, po.getPeopleNum());
			pps.setString(11, po.getCheckInDate().toString());
			pps.setString(12, po.getLatestArrivingTime().toString());
			pps.setString(13, po.getCheckOutDate().toString());
			pps.setInt(14, po.getTotal());
			pps.setString(15, po.getOrderState());
			
			if(po.getRevokingDateTime()!=null){
				pps.setTimestamp(16, Timestamp.valueOf(po.getRevokingDateTime()));
			}
			else {
				pps.setNull(16, Types.TIMESTAMP);
			}
			
			if(po.getExecutingDateTime()!=null){
				pps.setTimestamp(17, Timestamp.valueOf(po.getExecutingDateTime()));
			}
			else {
				pps.setNull(17, Types.TIMESTAMP);
			}
			
			if(po.getLeavingDateTime()!=null){
				pps.setTimestamp(18, Timestamp.valueOf(po.getLeavingDateTime()));
			}
			else {
				pps.setNull(18, Types.TIMESTAMP);
			}
			
			
			pps.setBoolean(19, false);
			pps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}



	@Override
	public int getNumOfAllOrders() {
		// TODO Auto-generated method stub
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT count(*) FROM ordertable";
			pps = con.prepareStatement(sql);
			
			ResultSet res = pps.executeQuery();
			int result = -1;
			if(res.next()){
				if(!res.wasNull()){
					result = res.getInt(1);
				}
			}
			
			return result;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return -1;
	}



	@Override
	public List<OrderPO> getOrderListByHotelID_CustomerID(int hotelID, int customerID) {
		// TODO Auto-generated method stub
		List<OrderPO> result = new ArrayList<OrderPO>();
		
		try{
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM ordertable WHERE hotelID = ? and customerID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			pps.setInt(2, customerID);
			
			ResultSet res =  pps.executeQuery();
			
			while(res.next()){
				OrderPO po = toOrderPO(res);
				result.add(po);
			}
			
			pps.close();
			con.close();
			
			return result;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	private OrderPO toOrderPO(ResultSet res) throws SQLException{
		int orderID = res.getInt(1);
		String customerName = res.getString(2);
		int customerID = res.getInt(3);
		LocalDateTime producingDateTime = LocalDateTime.ofInstant(res.getTimestamp(4).toInstant(), ZoneId.systemDefault());
		String hotelName = res.getString(5);
		int hotelID = res.getInt(6);
		String roomName = res.getString(7);
		int roomNum = res.getInt(8);
		boolean hasChildren = res.getBoolean(9);
		int peopleNum = res.getInt(10);
		LocalDate checkInDate = LocalDate.parse(res.getString(11));
		LocalTime latestArrivingTime = LocalTime.parse(res.getString(12));
		LocalDate checkOutDate = LocalDate.parse(res.getString(13));
		int total = res.getInt(14);
		String orderState = res.getString(15);
		LocalDateTime revokingDateTime = res.getTimestamp(16)!=null? LocalDateTime.ofInstant(res.getTimestamp(16).toInstant(), ZoneId.systemDefault()) : null;
		LocalDateTime executingDateTime = res.getTimestamp(17)!=null? LocalDateTime.ofInstant(res.getTimestamp(17).toInstant(), ZoneId.systemDefault()) : null;
		LocalDateTime leavingDateTime = res.getTimestamp(18)!=null? LocalDateTime.ofInstant(res.getTimestamp(18).toInstant(), ZoneId.systemDefault()) : null;
		boolean hasComment = res.getBoolean(19);
		
		OrderPO po = new OrderPO(orderID, customerName, customerID, producingDateTime, hotelName, hotelID, roomName, roomNum, hasChildren, peopleNum, checkInDate, latestArrivingTime, checkOutDate, total, orderState, revokingDateTime, executingDateTime, leavingDateTime, hasComment);
		return po;
	}

}
