package runner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import factory.BLFactory;
import factory.DataFactory;
import rmi.ControllerRemoteFactory;
import rmi.RemoteRegister;


/**
 * 服务器端启动类
 * 
 * @author sjl
 *
 */

public class ServerRunner {

	public static void main(String[] args) throws RemoteException{
		ServerRunner serverRunner = new ServerRunner();
		serverRunner.start();
	}
	
	
	/**
	 * 启动方法
	 * @throws RemoteException
	 */
	private void start() throws RemoteException{
		DataFactory.initDataFactory();
		BLFactory.initBLFactory();
		
	
		//System.setProperty("java.rmi.server.hostname ", "202.119.46.62");
		
		System.out.println("Data and BL ready...");
		
		
		UnicastRemoteObject controllerRemoteFactory = new ControllerRemoteFactory();
		RemoteRegister.register(controllerRemoteFactory);
		
		System.out.println("rmi ready...");
		
		JFrame jFrame = new JFrame();
		JPanel jPanel = new JPanel();
		JButton button = new JButton("exit server");
		jPanel.add(button);
		jFrame.add(jPanel);
		jFrame.setSize(400, 400);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					UnicastRemoteObject.unexportObject(controllerRemoteFactory, true);
				} catch (NoSuchObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
