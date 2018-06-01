package com.SingletonAssignment;

public class InsertCommand implements Command {

	private Queries queries;
	private String queriesImpl;
	
	public InsertCommand(Queries queries, String queriesImpl){
		this.queries = queries;
		this.queriesImpl = queriesImpl;
	}
	
	public void execute() {
		this.queries.insertQuery(queriesImpl);
		
	}
}	