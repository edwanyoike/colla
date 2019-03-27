package com.utilityapps.colla.services;

import com.utilityapps.colla.interfaces.HelpRequestI;
import com.utilityapps.colla.models.HelpRequest;
import com.utilityapps.colla.repositories.HelpRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpRequestService implements HelpRequestI {

    private final HelpRequestRepository helpRequestRepository;

    public HelpRequestService(HelpRequestRepository helpRequestRepository) {
        this.helpRequestRepository = helpRequestRepository;
    }

    @Override
    public HelpRequest save(HelpRequest helpRequest) {
        return helpRequestRepository.save(helpRequest);
    }

    @Override
    public HelpRequest findById(long id) {
        return helpRequestRepository.findById(id);
    }

    @Override
    public List<HelpRequest> findAll() {
        return helpRequestRepository.findAll();
    }

    @Override
    public List<HelpRequest> findByFrom(Long id) {
        return helpRequestRepository.findByFrom_Id(id);
    }

//    @Override
//    public List<HelpRequest> findAllByTo(Long id) {
//        return helpRequestRepository.findAllByTo_Id(id);
//    }

    @Override
    public List<HelpRequest> findByCollaProblemId(Long id) {
        return helpRequestRepository.findByCollaProblemId(id);
    }
}
