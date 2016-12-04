package po;

import java.time.LocalDateTime;

public class CommentPO {
	
	private int hotelID;
	private String nameOfHotel;
	private String nameOfRoom;
	private String comment;
	private double score;
	private LocalDateTime produingDateTime;
	private int customerID;

	
	public CommentPO(int hotelID, String nameOfHotel, String nameOfRoom, String comment, double score, 
						LocalDateTime producingDateTime, int customerID){
		this.hotelID = hotelID;
		this.nameOfHotel = nameOfHotel;
		this.nameOfRoom = nameOfRoom;
		this.comment = comment;
		this.score = score;
		this.produingDateTime = producingDateTime;
		this.customerID = customerID;
	}
	
	
	public void setHotelID(int hotelID){
		this.hotelID = hotelID;
	}
	
	public int getHotelID(){
		return this.hotelID;
	}
	
	public void setNameOfHotel(String nameOfHotel){
		this.nameOfHotel = nameOfHotel;
	}
	
	public String getNameOfHotel(){
		return this.nameOfHotel;
	}
	
	public void setNameOfRoom(String nameOfRoom){
		this.nameOfRoom = nameOfRoom;
	}
	
	public String getNameOfRoom(){
		return this.nameOfRoom;
	}
	
	public void setComment(String comment){
		this.comment = comment;
	}
	
	public String getComment(){
		return this.comment;
	}
	
	public void setScore(double score){
		this.score = score;
	}
	
	public double getScore(){
		return this.score;
	}
	
	
	
	public void setProducingDateTime(LocalDateTime producingDateTime){
		this.produingDateTime = producingDateTime;
	}
	
	public LocalDateTime getProducingDateTime(){
		return this.produingDateTime;
	}

	
	public void setCustomerID(int customerID){
		this.customerID = customerID;
	}
	
	public int getCustomerID(){
		return this.customerID;
	}
}
