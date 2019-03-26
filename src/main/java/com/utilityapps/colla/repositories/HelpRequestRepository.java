package com.utilityapps.colla.repositories;

import com.utilityapps.colla.models.HelpRequest;
import com.utilityapps.colla.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelpRequestRepository extends MongoRepository<HelpRequest,Long> {
    HelpRequest findById(long id);
    List<HelpRequest> findAll();
    List<HelpRequest> findByFrom_Id(Long id);

  //  List<HelpRequest> findAllByTo_Id(Long id);
    List<HelpRequest> findByCollaProblem_CreateddBy_Id(Long id);


}
