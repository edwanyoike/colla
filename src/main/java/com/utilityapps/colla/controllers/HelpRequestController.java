package com.utilityapps.colla.controllers;


import com.utilityapps.colla.interfaces.NextSequenceServiceI;
import com.utilityapps.colla.models.HelpRequest;
import com.utilityapps.colla.models.User;
import com.utilityapps.colla.services.HelpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HelpRequestController {
    private final HelpRequestService helpRequestService;
    private final NextSequenceServiceI nextSequenceService;

    @Autowired
    public HelpRequestController(HelpRequestService helpRequestService, NextSequenceServiceI nextSequenceService) {
        this.helpRequestService = helpRequestService;
        this.nextSequenceService = nextSequenceService;
    }

    @PostMapping("/helprequest")
    public String createRequest(@RequestBody HelpRequest helpRequest){

        helpRequest.setId(nextSequenceService.getNextSequence("customSequences"));

        if(helpRequestService.save(helpRequest)!= null)
        {
            return "done";
        }
        return "not done";
    }

    @GetMapping(value = "/helprequests") //for admin
    public ModelAndView getAll(ModelAndView modelAndView)
    {
        List<HelpRequest> helpRequests = helpRequestService.findAll();
        modelAndView.addObject("helpRequests",helpRequests);
        modelAndView.setViewName("requestlist");  //TODO add this view
        return modelAndView;

    }

    @GetMapping(value = "/singlerequest")
    public ModelAndView getRequestById(@RequestParam("id") long id,ModelAndView modelAndView ){

        HelpRequest helpRequest = helpRequestService.findById(id);
        modelAndView.addObject("requests",helpRequest);
        modelAndView.setViewName("requestlist");  //TODO add this view

        return modelAndView;


    }

    @GetMapping(value = "/getrequestbysender")
    public ModelAndView findBysender(@RequestParam("id") long id,ModelAndView modelAndView ){
        List<HelpRequest> requests = helpRequestService.findByFrom(id);
        modelAndView.addObject("requests",requests);
        modelAndView.setViewName("requestlist");  //TODO add this view

        return modelAndView;
    }


    @GetMapping(value = "/getrequestbyreceiver")
    public ModelAndView findByReceiver(@RequestParam("id") long id,ModelAndView modelAndView ){
        List<HelpRequest> requests = helpRequestService.findAllByTo(id);
        modelAndView.addObject("requests",requests);
        modelAndView.setViewName("requestlist");  //TODO add this view
        return modelAndView;
    }





}
