package po;

public class RoomPO {
	
	private int roomID;
	private int hotelID;
	private String roomName;
	private int price;
	private int peopleNum;
	private String introduction;
	private int roomNum;
	
	public RoomPO(int roomID, int hotelID, String roomName, int price, int peopleNum, String introduction, int roomNum) {
		// TODO Auto-generated constructor stub
		this.roomID = roomID;
		this.hotelID = hotelID;
		this.roomName = roomName;
		this.price = price;
		this.peopleNum = peopleNum;
		this.introduction = introduction;
		this.roomNum = roomNum;
	}
	
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	
	public int getRoomID() {
		return this.roomID;
	}
	
	public void setHotelID(int hotelID){
		this.hotelID = hotelID;
	}
	
	public int getHotelID(){
		return this.hotelID;
	}
	
	public void setRoomName(String roomName){
		this.roomName = roomName;
	}
	
	public String getRoomName(){
		return this.roomName;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPeopleNum(int peopleNum){
		this.peopleNum = peopleNum;
	}
	
	public int getPeopleNum(){
		return this.peopleNum;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getIntroduction() {
		return this.introduction;
	}
	
	public void setRoomNum(int roomNum){
		this.roomNum = roomNum;
	}
	
	public int getRoomNum(){
		return this.roomNum;
	}
}
