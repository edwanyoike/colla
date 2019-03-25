package com.utilityapps.colla.interfaces;

import com.utilityapps.colla.models.HelpRequest;
import com.utilityapps.colla.models.User;

import java.util.List;

public interface HelpRequestI {

    HelpRequest save(HelpRequest helpRequest);
    HelpRequest findById(long id);
    List<HelpRequest> findAll();
    List<HelpRequest> findByFrom(Long id);
    List<HelpRequest> findAllByTo(Long id);

}
