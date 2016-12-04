package rmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class TestRmi {

	public static void main(String[] args) throws Exception{
		Remote remote = Naming.lookup("rmi://localhost:8888/controllerRemoteFactory");
		System.out.print("success");
	}
	
}
