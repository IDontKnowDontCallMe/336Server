package data.promotiondata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import data.databaseutility.ConnectionFactory;
import po.HotelPromotionPO;

public class HotelPromotionDaoImpl implements HotelPromotionDao {
	private Connection con = null;
	private PreparedStatement pps = null;

	@Override
	public List<HotelPromotionPO> getHotelPromotionObject(int hotelID) {
		List<HotelPromotionPO> result = new ArrayList<HotelPromotionPO>();
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM hotelpromotiontable WHERE hotelID = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			ResultSet res = pps.executeQuery();

			while (res.next()) {
				HotelPromotionPO po = toHotelPromotionPO(res);
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
	public boolean writeHotelPromotionObject(int hotekID, HotelPromotionPO po) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO hotelpromotiontable  SET hotelID = ?, promotionType = ?, startTime = ?, endTime = ?, companyName = ?, minNum = ?, discount = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, po.getHotelID());
			pps.setString(2, po.getPromotionType());
			pps.setString(3, po.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-mm-dd")));
			pps.setString(4, po.getEndTime().format(DateTimeFormatter.ofPattern("yyyy-mm-dd")));
			pps.setString(5, po.getCompanyName());
			pps.setInt(6, po.getMinNum());
			pps.setDouble(7, po.getDiscount());
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteHotelPromotionObject(int hotelID, String promotionType) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "DELETE FROM hotelpromotiontable WHERE hotelID = ?, promotionType = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, hotelID);
			pps.setString(2, promotionType);
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private HotelPromotionPO toHotelPromotionPO(ResultSet res) throws SQLException {
		int hotelID = res.getInt(1);
		String promotionType = res.getString(2);
		LocalDate startTime = LocalDate.parse(res.getString(3));
		LocalDate endTime = LocalDate.parse(res.getString(4));
		String companyName = res.getString(5);
		int minNum = res.getInt(6);
		double discount = res.getDouble(7);

		HotelPromotionPO po = new HotelPromotionPO(hotelID, promotionType, startTime, endTime, companyName, minNum,
				discount);
		return po;

	}
}
