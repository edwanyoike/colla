package com.utilityapps.colla.repositories;


import com.utilityapps.colla.models.Problem;
import com.utilityapps.colla.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ewanyoike
 */

@Repository
public interface ProblemInterface extends MongoRepository<Problem, Long> {

    List findByCreateddBy(User user);
    List findBySolved();
}
