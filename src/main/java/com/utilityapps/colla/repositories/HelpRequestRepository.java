package com.utilityapps.colla.repositories;

import com.utilityapps.colla.models.HelpRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRequestRepository extends MongoRepository<HelpRequest,Long> {
}
