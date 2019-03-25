package com.utilityapps.colla.repositories;

import com.utilityapps.colla.auth.AuthGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthGroupRepository extends MongoRepository<AuthGroup,Long>  {


    List<AuthGroup> findByUsername(String uname);
}
