package org.example.caseservice;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.caseservice.model.Address;
import org.example.caseservice.model.Case;
import org.example.caseservice.repo.AddressRepository;
import org.example.caseservice.repo.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Loads generated test data
 * @author barryeva
 *
 */
@Component
public class DataLoader {
	
	private static final int ADDRESS_COUNT = 10;

	private static Log logger = LogFactory.getLog(DataLoader.class);
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private CaseRepository caseRepo;
	
	@PostConstruct
	public void loadData() {

		//Check size of Addresses
		if (addressRepo.count() == 0) {
			
			for(int addressCount = 0; addressCount < ADDRESS_COUNT; addressCount++) {
				Address newAddress = new Address("Line 1 " + addressCount, "Line 2 " + addressCount, "Town", "Code" + (addressCount % 3));
				
				newAddress = addressRepo.save(newAddress);
				
				caseRepo.save(new Case(newAddress, "Desc1"));
				caseRepo.save(new Case(newAddress, "Desc2"));
			}
			
			logger.info("Created " + addressRepo.count() + " address, "
			            + caseRepo.count() + " Cases");
		}
		else {
			logger.info("Data already present");
		}
	}
}
