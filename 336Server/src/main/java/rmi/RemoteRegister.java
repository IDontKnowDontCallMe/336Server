package rmi;

import java.net.MalformedURLException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteRegister {

	public static boolean register(UnicastRemoteObject remoteObject) {
		try {
			
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://172.26.102.100:8888/controllerRemoteFactory", remoteObject);
			
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (java.rmi.AlreadyBoundException e) {
 			e.printStackTrace();
		}
		
		return false;
	}

	
}
