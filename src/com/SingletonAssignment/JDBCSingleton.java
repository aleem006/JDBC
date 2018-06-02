//package com.SingletonAssignment;
//
//import java.io.*;
//import java.sql.*;
//
//
//public class JDBCSingleton {
//
//         private static JDBCSingleton jdbc;
//         
//         private JDBCSingleton() {
//         
//         }
//      
//         public static JDBCSingleton getInstance() {  
//                                     if (jdbc==null) {
//                                            jdbc=new   
//                                      JDBCSingleton();
//                                   }
//                         return jdbc;
//             }
//          
//          public ConnectionPool DBConnection(){
//              
//			try {
//				ConnectionPool connectionPool = new ConnectionPool("jdbc:postgresql://localhost:5432/student", "student", "student");
//				System.out.println("Connection Available "+ connectionPool.getFreeConnectionCount());
//	              return connectionPool;
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return null;
//              
//              
//          }
//
// }