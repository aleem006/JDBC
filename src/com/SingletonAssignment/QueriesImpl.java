package com.SingletonAssignment;

import java.sql.*;

public class QueriesImpl implements Queries{

	private Connection connection;
	
	public QueriesImpl(Connection connection){
		this.connection = connection;
	}

	public void selectQuery(String Query) {
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.createStatement();
			statement.execute(Query);
			resultSet = statement.executeQuery(Query);
			
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int numberOfColumns = resultSetMetaData.getColumnCount();
			
			for(int column = 1; column <= numberOfColumns; column++){
				String columnName = resultSetMetaData.getColumnLabel(column);
				System.out.print(columnName+ " ");
			}
			System.out.println();
			
			while(resultSet.next()){
				for(int i = 1; i<= numberOfColumns; i++)
					System.out.print(resultSet.getString(i)+ " ");
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteQuery(String Query) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(Query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updateQuery(String Query) {

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(Query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertQuery(String Query) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(Query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
