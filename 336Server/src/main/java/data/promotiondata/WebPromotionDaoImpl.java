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
import po.LevelPO;
import po.WebPromotionPO;

public class WebPromotionDaoImpl implements WebPromotionDao {

	private Connection con = null;
	private PreparedStatement pps = null;

	@Override
	public List<WebPromotionPO> getWebPromotionObject() {
		List<WebPromotionPO> result = new ArrayList<WebPromotionPO>();
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM webpromotiontable";
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();

			while (res.next()) {
				WebPromotionPO po = toWebPromotionPO(res);
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
	public boolean writeWebPromotionObject(WebPromotionPO po) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "INSERT INTO webpromotiontable  SET promotionType = ?, startTime = ?, endTime = ?, businessCircleName = ?, discount = ?";
			pps = con.prepareStatement(sql);
			pps.setString(1, po.getPromotionType());
			pps.setString(2, po.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-mm-dd")));
			pps.setString(3, po.getEndTime().format(DateTimeFormatter.ofPattern("yyyy-mm-dd")));
			pps.setString(4, po.getBusinessCircleName());
			pps.setDouble(5, po.getDiscount());
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteWebPromotionObject(String promotionType) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "DELETE FROM webpromotiontable WHERE promotionType = ?";
			pps = con.prepareStatement(sql);
			pps.setString(1, promotionType);
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public LevelPO getLevelObject() {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "SELECT * FROM leveltable";
			pps = con.prepareStatement(sql);
			ResultSet res = pps.executeQuery();

			LevelPO po = toLevelPO(res);

			pps.close();
			con.close();

			return po;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateLevelObject(LevelPO po) {
		try {
			con = ConnectionFactory.getDatabaseConnectionInstance();
			String sql = "UPDATE leveltable SET creditDistance = ?, maxLevel = ?, discountDistance = ?";
			pps = con.prepareStatement(sql);
			pps.setInt(1, po.getCreditDistance());
			pps.setInt(2, po.getMaxLevel());
			pps.setDouble(3, po.getDiscountDistance());
			pps.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	private WebPromotionPO toWebPromotionPO(ResultSet res) throws SQLException {
		String promotionType = res.getString(1);
		LocalDate startTime = LocalDate.parse(res.getString(2));
		LocalDate endTime = LocalDate.parse(res.getString(3));
		String businessCircleName = res.getString(4);
		double discount = res.getDouble(5);

		WebPromotionPO po = new WebPromotionPO(promotionType, startTime, endTime, businessCircleName, discount);
		return po;
	}

	private LevelPO toLevelPO(ResultSet res) throws SQLException {
		int creditDistance = res.getInt(1);
		int maxLevel = res.getInt(2);
		double discountDistance = res.getDouble(3);

		LevelPO po = new LevelPO(creditDistance, maxLevel, discountDistance);
		return po;
	}
}
