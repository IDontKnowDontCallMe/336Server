package po;

public class HotelPO {

	private int hotelID;
	private String hotelName;
	private String city;
	private String businessCircle;
	private String address;
	private String introduction;
	private String service;
	private String workerName;
	private String phoneNumber;
	private int score;
	private double commentScore;
	private int minPrice;
	private int bookedTag;

	public HotelPO(int hotelID, String hotelName, String city, String businessCircle, String address,
			String introduction, String service, String workerName, String phoneNumeber, int score, double commentScore,
			int minPrice, int bookedTag) {

		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.city = city;
		this.businessCircle = businessCircle;
		this.address = address;
		this.introduction = introduction;
		this.service = service;
		this.workerName = workerName;
		this.phoneNumber = phoneNumeber;
		this.score = score;
		this.commentScore = commentScore;
		this.minPrice = minPrice;
		this.bookedTag = bookedTag;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public int getHotelID() {
		return this.hotelID;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelName() {
		return this.hotelName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	public void setBusinessCircle(String businessCircle) {
		this.businessCircle = businessCircle;
	}

	public String getBusinessCircle() {
		return this.businessCircle;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getService() {
		return this.service;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerName() {
		return this.workerName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setCommentScore(double commentScore) {
		this.commentScore = commentScore;
	}

	public double getCommentScore() {
		return this.commentScore;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMinPrice() {
		return this.minPrice;
	}

	public void setBookedTag(int bookedTag) {
		this.bookedTag = bookedTag;
	}

	public int getBookedTag() {
		return this.bookedTag;
	}
}
