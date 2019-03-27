package com.utilityapps.colla.repositories;

import com.utilityapps.colla.models.CollaError;
import com.utilityapps.colla.models.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaErrorRepository extends MongoRepository<CollaError,Long> {

    List findByCreateddBy(User user);
    List findBySolved();
    CollaError findById(long id);
}
