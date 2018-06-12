package com.SingletonAssignment;

import java.util.ArrayList;

public class Result{
	
	private static Result result;
	
	ArrayList<String> resultList = new ArrayList<String>();
	
	private Result(){
		
	}
	
	public static Result getInstance(){
		if(result == null){
			result = new Result();
		}
		return result;
	}
}