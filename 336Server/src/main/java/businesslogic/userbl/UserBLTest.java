package businesslogic.userbl;

import java.rmi.Naming;
import java.rmi.Remote;

import businesslogicservice.userblservice.UserBLService;
import rmi.RemoteUserBLService;

public class UserBLTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int userID = 100000001;
		String password = "3361001";
		
		Remote remote = Naming.lookup("rmi://localhost:8888/controllerRemoteFactory");
		
		RemoteUserBLService userBLService = (RemoteUserBLService)remote;
		
		System.out.println(userBLService.login(userID, password));
	}

}
