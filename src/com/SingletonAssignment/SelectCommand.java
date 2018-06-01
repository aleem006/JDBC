package com.SingletonAssignment;

public class SelectCommand implements Command{

	private Queries queries;
	private String queriesImpl;
	
	public SelectCommand(Queries queries, String queriesImpl){
		this.queries = queries;
		this.queriesImpl = queriesImpl;
		
	}
	
	public void execute() {
		this.queries.selectQuery(queriesImpl);
		
	}

}
