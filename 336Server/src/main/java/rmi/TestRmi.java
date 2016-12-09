package rmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.AreaVO;

public class TestRmi {

	public static void main(String[] args) throws Exception{
		Remote remote = Naming.lookup("rmi://localhost:8888/controllerRemoteFactory");
		System.out.println("success" + remote!=null);
		RemoteOrderBLService orderBLService = (RemoteOrderBLService)remote;
		RemoteHotelBLService hotelBLService = (RemoteHotelBLService)remote;
		System.out.println(hotelBLService.getHotelVOsOfArea(new AreaVO("南京", "栖霞区"), 100000001).get(1).hotelName);
	}
	
}
