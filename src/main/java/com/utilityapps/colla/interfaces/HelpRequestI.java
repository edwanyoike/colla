package com.utilityapps.colla.interfaces;

import com.utilityapps.colla.models.HelpRequest;

import java.util.List;
import java.util.Optional;

public interface HelpRequestI {

    HelpRequest save(HelpRequest helpRequest);
    Optional<HelpRequest> findById(long id);
    List<HelpRequest> findAll();
    List<HelpRequest> findByFrom(Long id);
    //List<HelpRequest> findAllByTo(Long id);
    List<HelpRequest> findByCollaProblemId(Long id);

}
