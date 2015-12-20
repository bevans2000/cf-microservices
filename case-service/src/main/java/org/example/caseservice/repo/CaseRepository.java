package org.example.caseservice.repo;

import org.example.caseservice.model.Case;
import org.springframework.data.repository.CrudRepository;

public interface CaseRepository extends CrudRepository<Case, Long> {

    //Case findByUprn(String uprn);

}
