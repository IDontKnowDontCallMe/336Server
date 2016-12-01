package rmi;

import java.net.MalformedURLException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String args[]) {
		ControllerRemoteFactory controllerRemoteFactory;
		try {
			controllerRemoteFactory = new ControllerRemoteFactory();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://localhost:8888/controllerRemoteFactory", controllerRemoteFactory);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (java.rmi.AlreadyBoundException e) {
 			e.printStackTrace();
		}
	}

}
