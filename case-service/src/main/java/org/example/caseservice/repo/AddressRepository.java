package org.example.caseservice.repo;

import java.util.List;

import org.example.caseservice.model.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

	/**
	 * 
	 * @param postcode Uses the @Param to be accessible from URL
	 * @return
	 */
	public List<Address> findByPostcode(@Param("postcode") String postcode);
}
