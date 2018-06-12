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
			
			Result result = Result.getInstance();
			result.resultList.clear();
			
			String column_name = null;
			for(int column = 1; column <= numberOfColumns; column++){
				String columnName = resultSetMetaData.getColumnLabel(column);
				System.out.print(columnName+ " ");
				if(column == 1){
					column_name = (columnName+" ");
				}else{
					column_name+=(columnName+"");
				}
			}
			System.out.println();
			result.resultList.add(column_name);
			
			
			while(resultSet.next()){
				String row =null;
				for(int i = 1; i<= numberOfColumns; i++){
					System.out.print(resultSet.getString(i)+ " ");
				if(i == 1){
		    		row=(resultSet.getString(i)+" ");
		    	}
		    	else{
		    		row+=(resultSet.getString(i)+" ");
		    	}
			}
				result.resultList.add(row);
				System.out.println();
			}
			connection.close();
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
