package com.utilityapps.colla.repositories;

import com.utilityapps.colla.models.CollaProblem;
import com.utilityapps.colla.models.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaProblemRepository extends MongoRepository<CollaProblem,Long> {

    List findByCreateddBy(User user);
    List findBySolved();
    CollaProblem findById(long id);
}
