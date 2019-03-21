package com.utilityapps.colla.repositories;

import com.utilityapps.colla.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author ewanyoike
 */

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    User findUserByUsername(String username);

}
