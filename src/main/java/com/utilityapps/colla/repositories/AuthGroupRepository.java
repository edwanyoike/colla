package com.utilityapps.colla.repositories;

import com.utilityapps.colla.auth.AuthGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthGroupRepository extends MongoRepository<AuthGroup,Long> {

    List<AuthGroup> findByUsername(String uname);
}
