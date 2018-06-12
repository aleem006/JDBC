package com.SingletonAssignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.registry.*;
import java.util.ArrayList;

public class Client {
	
	//private static final String host = "localhost";
	
	public Client(){
		
	}
	
	public static void main(String[] args){
	
	
	try {
		//getting rmi registry
		//RMI stub = (RMI) Naming.lookup("rmi://"+host+"/rmi_test");
		
		Registry registry = LocateRegistry.getRegistry(null);
		RMI stub = (RMI) registry.lookup("RMI");
		
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       // QueriesImpl queriesImpl = null ;
        
        String inputQuery = "Open";
        
        System.out.println("Enter 'quit' or 'QUIT' command to exit from CLI.");
        
        while(!(inputQuery.equalsIgnoreCase("quit"))){
        	System.out.println("/>");
        	inputQuery = br.readLine();
        	ArrayList<String> result;
        	result = (ArrayList<String>) stub.dataConnection(inputQuery);
        	
        	if(result != null){
        		for(int i=0; i<result.size(); i++){
        			
        			String [] values = result.get(i).split("");
        			for(int j=0; j<values.length; j++){
        				System.out.print(values[j] +"");
        			}
        			System.out.println();
        		}
        	}
        }br.close();

		
	} catch (Exception e) {
		System.err.println("Client Exception: "+e.toString());
		e.printStackTrace();
	}
	
	
	}
}
