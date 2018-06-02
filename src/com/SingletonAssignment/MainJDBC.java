package com.SingletonAssignment;


import java.io.*;
import java.sql.*;

public class MainJDBC {
	
    public static void main(String[] args) throws IOException, SQLException {
    	
//    	JDBCSingleton jdbc= JDBCSingleton.getInstance();
    	ConnectionPool connectionPool = ConnectionPool.getInstance();
    	
//    	ConnectionPool connectionPool = jdbc.DBConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        QueriesImpl queriesImpl = new QueriesImpl(connectionPool.getConnection());
        
        String inputQuery = "Open";
        
        System.out.println("Enter 'quit' or 'QUIT' command to exit from CLI.");
        
        while(!(inputQuery.equalsIgnoreCase("quit"))){
        	System.out.println("/>");
        	inputQuery = br.readLine();
        	if(inputQuery.startsWith("select")|| inputQuery.startsWith("SELECT")){
        		SelectCommand selectCommand = new SelectCommand(queriesImpl, inputQuery);
        		Invoker invoker = new Invoker(selectCommand);
        		invoker.execute();
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
        }
    }
 }

