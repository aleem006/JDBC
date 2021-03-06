package com.SingletonAssignment;

import java.sql.*;
import java.util.*;

public class ConnectionPool {
	
	private static ConnectionPool connectionPool;
	
	private List<Connection>connections = new ArrayList<Connection>();
	private final int Max_Connection = 8;
	
	private String URL;
	private String USERID;
	private String PASSWORD;
	
	public static ConnectionPool getInstance() {
		if(connectionPool == null){
			connectionPool = new ConnectionPool();
			
			connectionPool.initializeConnections("jdbc:postgresql://localhost:5432/student", "student", "student");
			System.out.println("Connection Available "+ connectionPool.getFreeConnectionCount());

//			connectionPool.DBConnection();
		}
		return connectionPool;
	}
	private void initializeConnections(String Url, String UserId, String Password){
		this.URL = Url;
		this.USERID = UserId;
		this.PASSWORD = Password;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i<Max_Connection; i++){
			try {
				connections.add(this.createConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
//
//	public ConnectionPool DBConnection(){
//        
//		try {
//			ConnectionPool connectionPool = new ConnectionPool("jdbc:postgresql://localhost:5432/student", "student", "student");
//			System.out.println("Connection Available "+ connectionPool.getFreeConnectionCount());
//            return connectionPool;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//        
//        
//    }

	
//	private ConnectionPool(String Url, String UserId, String Password){
//		this.URL = Url;
//		this.USERID = UserId;
//		this.PASSWORD = Password;
//		
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		for(int i = 0; i<Max_Connection; i++){
//			try {
//				connections.add(this.createConnection());
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
	
	private Connection createConnection() throws SQLException {
		return DriverManager.getConnection(this.URL, this.USERID, this.PASSWORD);
	}
	
	public Connection getConnection(){
		if(connections.size() == 0){
			System.out.println("All Connections are in use!!!!");
			return null;
		}else{
			Connection connection = connections.remove(connections.size() -1);
			return connection;
		}
	}
	
	public boolean releaseConnection(Connection connection){
		if (null != connection){
			connections.add(connection);
			return true;
		}
		return false;
	}
	
	public int getFreeConnectionCount(){
		return connections.size();
	}

}
