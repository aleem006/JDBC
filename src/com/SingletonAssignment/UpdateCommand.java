package com.SingletonAssignment;

public class UpdateCommand implements Command {

	private String queriesImpl;
	private Queries queries;
	
	public UpdateCommand(Queries queries, String queriesImpl){
		this.queries = queries;
		this.queriesImpl = queriesImpl;
	}
	
	public void execute() {
		this.queries.updateQuery(queriesImpl);
	}

}
