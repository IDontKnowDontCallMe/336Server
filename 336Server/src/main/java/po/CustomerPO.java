package po;

import java.time.LocalDate;

public class CustomerPO {

	private String name;
	private String phoneNumber;
	private LocalDate VIPbirthday;
	private String VIPcompany;

	private int credit;
	//private int level;

	private int ID;
	private boolean isBirthVIP;
	private boolean isCompanyVIP;

	public CustomerPO(String name, String phoneNumber, int id, LocalDate VIPbirthday, String VIPcompany, int credit,
			  boolean isbirthvip, boolean iscompvip) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.ID = id;
		this.VIPbirthday = VIPbirthday;
		this.VIPcompany = VIPcompany;
		this.credit = credit;
		//this.level = level;
		this.isBirthVIP = isbirthvip;
		this.isCompanyVIP = iscompvip;

	}
	
	public void setID(int id) {
		this.ID = id;
	}

	public int getID() {
		return this.ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setVIPbirthday(LocalDate VIPbirthday) {
		this.VIPbirthday = VIPbirthday;
	}

	public LocalDate getVIPbirthday() {
		return this.VIPbirthday;
	}

	public void setVIPcompany(String VIPcompany) {
		this.VIPcompany = VIPcompany;
	}

	public String getVIPcompany() {
		return this.VIPcompany;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getCredit() {
		return this.credit;
	}

	/**
	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
	**/

	public void setBirthVIP(boolean isBirthVIP) {
		this.isBirthVIP = isBirthVIP;
	}

	public boolean isBirthVIP() {
		return this.isBirthVIP;
	}

	public void setCompanyVIP(boolean isCompanyVIP) {
		this.isCompanyVIP = isCompanyVIP;
	}

	public boolean isCompanyVIP() {
		return this.isCompanyVIP;
	}
}
