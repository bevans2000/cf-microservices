package org.example.caseservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Represents a simple persistent entity
 * @author barryeva
 *
 */
@Entity
public class Case {

	private @Id @GeneratedValue Long id;
	private String uprn;
	
	public Case() {
		
	}
	
	/**
	 * @param uPRN
	 */
	public Case(String uprn) {
		super();
		uprn = uprn;
	}
	
	public Long getId() {
		return id;
	}
	public String getUprn() {
		return uprn;
	}
	
}
