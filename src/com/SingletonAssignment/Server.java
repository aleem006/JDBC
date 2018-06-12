package com.SingletonAssignment;

import java.rmi.Naming;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Server {
	
//	private static final String host = "localhost";
	//invoke remote object
	public Server(){
	}
	
	public static void main(String[] args) {
		
		try {
			
			MainJDBC jdbc = new MainJDBC();
			
			//String rmiobj = "rmi://"+host+"/rmi_test";
//			RMIImpl obj = new RMIImpl();//creating remote object
			
			//exporting remote object to stub
			RMI stub = (RMI) UnicastRemoteObject.exportObject(jdbc,0);
			
			Registry registry = LocateRegistry.getRegistry();//Getting RMI Registry
			registry.rebind("RMI", stub);
			
			//Naming.rebind(rmiobj, jdbc);
			
			System.err.println("Server Ready");
			
		} catch (Exception e) {
			System.err.println("Server exception :" +e.toString());
			e.printStackTrace();
		}
		
		}

}
