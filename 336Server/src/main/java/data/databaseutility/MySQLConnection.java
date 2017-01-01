package data.databaseutility;
import java.sql.*;


public class MySQLConnection implements DatabaseConnection{
	
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=true&&useUnicode=true&characterEncoding=UTF-8";

	private static final String userName = "root";
	private static final String password = "a4s5d6f1";
	
	//private Connection con = null;
	
	public MySQLConnection() {
		// TODO Auto-generated constructor stub
		
		try{
			Class.forName(driverName);
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection con = null;
		try{
			con = DriverManager.getConnection(URL, userName, password);
			
			if(con==null){
				System.out.println("connection is null!");
			}
			else{
				//System.out.println("connect to ->->->" + con);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}

	
	
	
}
