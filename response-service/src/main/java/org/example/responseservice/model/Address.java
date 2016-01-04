package org.example.responseservice.model;


public class Address {
	
	private Long uprn;
	private String line1;
	private String line2;
	private String posttown;
	private String postcode;
	
	public Address() {
		
	}

	public Long getUprn() {
		return uprn;
	}
	public String getLine1() {
		return line1;
	}
	public String getLine2() {
		return line2;
	}

	public String getPosttown() {
		return posttown;
	}

	public String getPostcode() {
		return postcode;
	}
	
}
