package data.userdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import data.databaseutility.ConnectionFactory;
import po.CustomerPO;

public class CustomerDaoImpl implements CustomerDao {
	private Connection con = null;
	private PreparedStatement pps = null;

	@Override
	public List<CustomerPO> getCustomerList() {
		List<CustomerPO> result = new ArrayList<CustomerPO>();
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM customertable";
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();

			while (res.next()) {
				CustomerPO po = toCustomerPO(res);
				result.add(po);
			}

			pps.close();
			con.close();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteCustomer(int customerID) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "DELETE FROM customertable WHERE customerID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(3, customerID);
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean insertCustomer(CustomerPO po) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO customertable  SET name = ?, phoneNumber = ?, id = ?, birthday = ?,"
					+ "company = ?, credit = ?, level = ?, isBirthVIP = ?, is companyVIP = ?";
			pps = con.prepareStatement(sql);
			pps.setString(1, po.getName());
			pps.setString(2, po.getPhoneNumber());
			pps.setInt(3, po.getID());
			pps.setString(4, po.getVIPbirthday().format(DateTimeFormatter.ofPattern("yyyy-mm-dd")));
			pps.setString(5, po.getVIPcompany());
			pps.setInt(6, po.getCredit());
			pps.setInt(7, po.getLevel());
			pps.setBoolean(8, po.isBirthVIP());
			pps.setBoolean(9, po.isCompanyVIP());
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private CustomerPO toCustomerPO(ResultSet res) throws SQLException {
		String name = res.getString(1);
		String phoneNumber = res.getString(2);
		int ID = res.getInt(3);
		LocalDate birthday = LocalDate.parse(res.getString(4));
		String company = res.getString(5);
		int credit = res.getInt(6);
		int level = res.getInt(7);
		boolean isBirthVIP = res.getBoolean(8);
		boolean isCompanyVIP = res.getBoolean(9);

		CustomerPO po = new CustomerPO(name, phoneNumber, ID, birthday, company, credit, level, isBirthVIP,
				isCompanyVIP);
		return po;
	}

}
