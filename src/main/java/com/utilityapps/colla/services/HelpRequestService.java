package com.utilityapps.colla.services;

import com.utilityapps.colla.interfaces.HelpRequestI;
import com.utilityapps.colla.repositories.HelpRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class HelpRequestService implements HelpRequestI {

    private final HelpRequestRepository helpRequestRepository;

    public HelpRequestService(HelpRequestRepository helpRequestRepository) {
        this.helpRequestRepository = helpRequestRepository;
    }
}
