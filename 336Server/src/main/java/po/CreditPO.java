package po;

import java.time.LocalDateTime;

public class CreditPO {
	
	private int customerID;
	private LocalDateTime time;
	private String orderID;
	private String actionType;
	private int delta;
	private int result;
	
	public CreditPO(int customerID, LocalDateTime time, String orderID, String actionType, int delta, int result){
		this.customerID = customerID;
		this.time = time;
		this.orderID = orderID;
		this.actionType = actionType;
		this.delta =delta;
		this.result = result;
		
	}
	
	public void setCustomerID(int customerID){
		this.customerID = customerID;
	}
	
	public int getCustomerID(){
		return this.customerID;
	}
	
	public void setTime(LocalDateTime time){
		this.time = time;
	}
	
	public LocalDateTime getTime(){
		return this.time;
	}
	
	public void setOrderID(String orderID){
		this.orderID = orderID;
	}
	
	public String getOrderID(){
		return this.orderID;
	}
	
	public void setActionType(String actionType){
		this.actionType = actionType;
	}
	
	public String getActionType(){
		return this.actionType;
	}
	
	public void setDelta(int delta){
		this.delta = delta;
	}
	
	public int getDelta(){
		return this.delta;
	}
	
	public void setResult(int result){
		this.result = result;
	}
	
	public int getResult(){
		return this.result;
	}

}
