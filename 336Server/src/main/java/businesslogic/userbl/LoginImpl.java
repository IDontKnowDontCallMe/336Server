package businesslogic.userbl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;

import factory.DataFactory;

public class LoginImpl {

	private Map<Integer, Integer> preUser;
	
	private Timer scanner;
	
	public LoginImpl() {
		// TODO Auto-generated constructor stub
		preUser = new LinkedHashMap<Integer, Integer>();
		scanner = new Timer(true);
		scanner.schedule(new ScanTask(), 3000, 1000);
	}
	
	public void survivalConfirm(int userID){
		
		if(!preUser.containsKey(userID)){
			preUser.put(userID, 7);
		}
		else{
			preUser.replace(userID, 7);
		}
		
	}
	
	
	public String login(int userID, String password) {
		if(preUser.containsKey(userID)){
			//if(preUser.get(userID) > 0)
			if(false)
			return "has logined";
		}
		
		String encodePassword = DataFactory.getUserDataService().getPassword(userID);
		if(encodePassword.equals("NOT_FOUND")){
			return "NOT_FOUND";
		}
		
		System.out.println("233");
		
		String realPassword = SimpleCoder.AESDncode("336336", encodePassword);
		String result = "";
		
		if(password.equals(realPassword)){
			System.out.println("right password");
			
			survivalConfirm(userID);
			
			if (userID / 100000000 == 1) {
				System.out.println("customer logs in.");
				result = "customer";
			} else if (userID / 100000000 == 2) {
				System.out.println("hotel worker logs in.");
				result = "hotelWorker";
			} else if (userID / 100000000 == 4) {
				System.out.println("web marketer logs in.");
				result = "webMarketer";
			} else if (userID / 100000000 == 5) {
				System.out.println("web manager logs in.");
				result = "webManager";
			}
			
			return result;
		}
		else{
			return "password wrong";
		}
		
		
	}
	
	public class ScanTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(preUser.size()>0){
				for(Entry<Integer, Integer> entry: preUser.entrySet()){
					int temp = entry.getValue();
					if(temp>0){
						entry.setValue(temp-1);
					}
				}
			}
		}
		
	}
	
}
