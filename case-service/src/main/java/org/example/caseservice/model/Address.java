package org.example.caseservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	private @Id @GeneratedValue Long uprn;
	
	private String line1;
	private String line2;
	private String posttown;
	private String postcode;
	
	public Address() {
		
	}
	

	/**
	 * @param line1
	 * @param line2
	 * @param posttown
	 * @param postcode
	 */
	public Address(String line1, String line2, String posttown, String postcode) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.posttown = posttown;
		this.postcode = postcode;
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
