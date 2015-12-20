package org.example.caseservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Represents a simple persistent entity
 * @author barryeva
 *
 */
@Entity
public class Case {

	private @Id @GeneratedValue Long id;
	
	@ManyToOne(optional = false)
	private Address address;
	
	private String description;
	
	public Case() {
		
	}

	
	/**
	 * @param address
	 * @param description
	 */
	public Case(Address address, String description) {
		super();
		this.address = address;
		this.description = description;
	}


	public Long getId() {
		return id;
	}


	public Address getAddress() {
		return address;
	}


	public String getDescription() {
		return description;
	}

	
}
