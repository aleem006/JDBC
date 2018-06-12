package com.SingletonAssignment;

import java.rmi.Remote;
import java.util.ArrayList;

public interface RMI extends Remote{
	//declare business method that invoke by client
	public ArrayList<String> dataConnection(String query) throws Exception;
}
