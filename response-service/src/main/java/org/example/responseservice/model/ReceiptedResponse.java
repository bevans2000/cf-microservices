package org.example.responseservice.model;

import java.util.Date;

public class ReceiptedResponse {
	
	private Date receipted;
	
	private Response response;
	
	private String address;

	public ReceiptedResponse(Response response, String address) {
		super();
		receipted = new Date();
		this.response = response;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}
	
	public Date getReceipted() {
		return receipted;
	}

	public Response getResponse() {
		return response;
	}
	

	
}
