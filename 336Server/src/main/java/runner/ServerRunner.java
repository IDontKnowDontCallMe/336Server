package runner;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import factory.BLFactory;
import factory.DataFactory;
import rmi.ControllerRemoteFactory;
import rmi.RemoteRegister;

public class ServerRunner {

	public static void main(String[] args) throws RemoteException{
		ServerRunner serverRunner = new ServerRunner();
		serverRunner.start();
	}
	
	private void start() throws RemoteException{
		BLFactory.initBLFactory();
		DataFactory.initDataFactory();
		
		System.out.println("Data and BL ready...");
		
		UnicastRemoteObject controllerRemoteFactory = new ControllerRemoteFactory();
		RemoteRegister.register(controllerRemoteFactory);
		
		System.out.println("rmi ready...");
	}
	
}
