package com.SingletonAssignment;

public class DeleteCommand implements Command{

	private Queries queries;
	private String QueriesImpl;
	
	public DeleteCommand(Queries queries, String queriesImpl){
		this.queries = queries;
		this.QueriesImpl = queriesImpl;
	}
	
	public void execute() {
		this.queries.deleteQuery(QueriesImpl);
		
	}

}
