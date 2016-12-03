package data.userdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.databaseutility.ConnectionFactory;
import po.WebMarketerPO;

public class WebMarketerDaoImpl implements WebMarketerDao {

	private Connection con = null;
	private PreparedStatement pps = null;

	@Override
	public boolean insertWebMarketer(WebMarketerPO po) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO webmarketertable  SET ID = ?, name = ?, phoneNumber = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, po.getWebMarketerID());
			pps.setString(2, po.getName());
			pps.setString(3, po.getPhoneNumber());
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<WebMarketerPO> getWebMarketerList() {

		List<WebMarketerPO> result = new ArrayList<WebMarketerPO>();
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM webmarketertable";
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();

			while (res.next()) {
				WebMarketerPO po = toWebMarketerPO(res);
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
	public boolean deleteWebMarketer(int webMarketerID) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "DELETE FROM webmarketertable WHERE ID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, webMarketerID);
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private WebMarketerPO toWebMarketerPO(ResultSet res) throws SQLException {
		int ID = res.getInt(1);
		String name = res.getString(2);
		String phoneNumeber = res.getString(3);
		WebMarketerPO po = new WebMarketerPO(ID, name, phoneNumeber);
		return po;
	}
}
