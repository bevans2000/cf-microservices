package org.example.responseservice.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Response {

	private int qid;
	private Date submitted;
	private String variables;
	
	public Response() {
	}
	
	public int getQid() {
		return qid;
	}
	public Date getSubmitted() {
		return submitted;
	}
	public String getVariables() {
		return variables;
	}
	
	
	
}
