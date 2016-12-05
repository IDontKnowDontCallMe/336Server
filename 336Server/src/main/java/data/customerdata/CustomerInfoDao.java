package data.customerdata;

import java.time.LocalDate;
import po.CustomerPO;

public interface CustomerInfoDao {
	public CustomerPO getInfo(int customerID);

	public boolean updateInfo(CustomerPO po);

	public boolean setBirthVIP(int customerID, LocalDate birthday);

	public boolean setCompanyVIP(int customerID, String companyName);
}
