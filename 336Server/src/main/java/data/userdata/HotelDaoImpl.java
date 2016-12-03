package data.userdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.databaseutility.ConnectionFactory;
import po.HotelPO;

public class HotelDaoImpl implements HotelDao {
	private Connection con = null;
	private PreparedStatement pps = null;

	@Override
	public List<HotelPO> getHotelList() {
		List<HotelPO> result = new ArrayList<HotelPO>();
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM hoteltable";
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();

			while (res.next()) {
				HotelPO po = toHotelPO(res);
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
	public boolean deleteHotel(int hotelID) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "DELETE FROM hoteltable WHERE hotelID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean insertHotel(HotelPO po) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO hoteltable  SET hotelID = ?, hotelName = ?, city = ?, businessCIrcle = ?, "
					+ "address = ?, introduction = ?, service = ?, workerName = ?, phoneNumber = ?, score = ?, "
					+ "commentScore = ?, minPrice = ?, bookedTag = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, po.getHotelID());
			pps.setString(2, po.getHotelName());
			pps.setString(3, po.getCity());
			pps.setString(4, po.getBusinessCircle());
			pps.setString(5, po.getAddress());
			pps.setString(6, po.getIntroduction());
			pps.setString(7, po.getService());
			pps.setString(8, po.getWorkerName());
			pps.setString(9, po.getPhoneNumber());
			pps.setInt(10, po.getScore());
			pps.setDouble(11, po.getCommentScore());
			pps.setInt(12, po.getMinPrice());
			pps.setInt(13, po.getBookedTag());
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private HotelPO toHotelPO(ResultSet res) throws SQLException {
		int hotelID = res.getInt(1);
		String hotelName = res.getString(2);
		String city = res.getString(3);
		String businessCircle = res.getString(4);
		String address = res.getString(5);
		String introduction = res.getString(6);
		String service = res.getString(7);
		String workerName = res.getString(8);
		String phoneNumeber = res.getString(9);
		int score = res.getInt(10);
		double commentScore = res.getDouble(11);
		int minPrice = res.getInt(12);
		int bookedTag = res.getInt(13);

		HotelPO po = new HotelPO(hotelID, hotelName, city, businessCircle, address, introduction, service, workerName,
				phoneNumeber, score, commentScore, minPrice, bookedTag);
		return po;
	}
}
