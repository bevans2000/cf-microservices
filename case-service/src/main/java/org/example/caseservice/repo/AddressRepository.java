package org.example.caseservice.repo;

import java.util.List;

import org.example.caseservice.model.Address;
import org.springframework.data.repository.CrudRepository;


public interface AddressRepository extends CrudRepository<Address, Long> {

	public List<Address> findByPostcode(String postcode);
}
