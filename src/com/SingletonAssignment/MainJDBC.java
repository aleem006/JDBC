package com.SingletonAssignment;


import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;

public class MainJDBC implements RMI  {
	
//	protected MainJDBC() throws RemoteException {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	//private QueriesImpl queriesImpl;
	
//    public static void main(String[] args) throws IOException, SQLException {
    	
//    	JDBCSingleton jdbc= JDBCSingleton.getInstance();
    	ConnectionPool connectionPool = ConnectionPool.getInstance();
    	
//    	ConnectionPool connectionPool = jdbc.DBConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        QueriesImpl queriesImpl = new QueriesImpl(connectionPool.getConnection());

//        //public MainJDBC() throws RemoteException {
//        	queriesImpl = new QueriesImpl(connectionPool.get);
//        //}
        
        
        
//        System.out.println("Enter 'quit' or 'QUIT' command to exit from CLI.");
        
        
//    }

	public ArrayList<String> dataConnection(String inputQuery) throws Exception {
		//String inputQuery = "Open";

		
//		while(!(inputQuery.equalsIgnoreCase("quit"))){
//        	System.out.println("/>");
//        	inputQuery = br.readLine();
        	if(inputQuery.startsWith("select")|| inputQuery.startsWith("SELECT")){
        		SelectCommand selectCommand = new SelectCommand(queriesImpl, inputQuery);
        		Invoker invoker = new Invoker(selectCommand);
        		invoker.execute();
        		return Result.getInstance().resultList;
        	}else if(inputQuery.startsWith("update")|| inputQuery.startsWith("UPDATE")){
        		UpdateCommand updateCommand = new UpdateCommand(queriesImpl, inputQuery);
        		Invoker invoker = new Invoker(updateCommand);
        		invoker.execute();
        	}else if(inputQuery.startsWith("delete")|| inputQuery.startsWith("DELETE")){
        		DeleteCommand deleteCommand = new DeleteCommand(queriesImpl, inputQuery);
        		Invoker invoker = new Invoker(deleteCommand);
        		invoker.execute();
        	}else if(inputQuery.startsWith("insert")|| inputQuery.startsWith("INSERT")){
        		InsertCommand insertCommand = new InsertCommand(queriesImpl, inputQuery);
        		Invoker invoker = new Invoker(insertCommand);
        		invoker.execute();
        	}else if(!(inputQuery.equalsIgnoreCase("Quit"))){
        		System.out.println("invalid command");
        	}
        //}
		return null;
	}

 }

