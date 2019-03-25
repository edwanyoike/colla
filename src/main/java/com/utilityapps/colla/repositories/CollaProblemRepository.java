package com.utilityapps.colla.repositories;

import com.utilityapps.colla.models.CollaProblem;
import com.utilityapps.colla.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CollaProblemRepository extends MongoRepository<CollaProblem,Long> {

    List findByCreateddBy(User user);
    List findBySolved();
}
