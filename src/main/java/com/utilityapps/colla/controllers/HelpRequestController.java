package com.utilityapps.colla.controllers;


import com.utilityapps.colla.interfaces.HelpRequestI;
import com.utilityapps.colla.interfaces.NextSequenceServiceI;
import com.utilityapps.colla.interfaces.UserServiceI;
import com.utilityapps.colla.models.HelpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
public class HelpRequestController {
    private final HelpRequestI helpRequestService;
    private final NextSequenceServiceI nextSequenceService;
    private final UserServiceI userService;

    @Autowired
    public HelpRequestController(HelpRequestI helpRequestService, NextSequenceServiceI nextSequenceService, UserServiceI userService) {
        this.helpRequestService = helpRequestService;

        this.nextSequenceService = nextSequenceService;
        this.userService = userService;
    }

    @PostMapping("/helprequest")
    public String createRequest(@RequestBody HelpRequest helpRequest, HttpSession session){

        helpRequest.setDateCreated(new Date());
        System.out.println(session.toString()+",.......................");
//        long id  = Long.valueOf( session.getAttribute("id").toString() );
        helpRequest.setFrom(userService.findUserById(Long.valueOf(7)));

        helpRequest.setId(nextSequenceService.getNextSequence("customSequences"));

        if(helpRequestService.save(helpRequest)!= null)
        {
            return "done";
        }
        return "not done";
    }

    @GetMapping(value = "/helprequest") //for admin
    public ModelAndView getAll(ModelAndView modelAndView)
    {
        List<HelpRequest> helpRequests = helpRequestService.findAll();
        modelAndView.addObject("helpRequests",helpRequests);
        modelAndView.setViewName("help-request-table");  //TODO add this view
        return modelAndView;

    }

    @GetMapping(value = "/helprequest/{id}")
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


  /*  @GetMapping(value = "/getrequestbyreceiver")
    public ModelAndView findByReceiver(@RequestParam("id") long id,ModelAndView modelAndView ){
        List<HelpRequest> requests = helpRequestService.findAllByTo(id);
        modelAndView.addObject("requests",requests);
        modelAndView.setViewName("requestlist");  //TODO add this view
        return modelAndView;
    }*/

    public String getRequestsToLoggedInUser(HttpServletRequest request){

        Long id  = Long.valueOf( request.getSession(false).getAttribute("id").toString() );
        List<HelpRequest> helpRequests = helpRequestService.findByCollaProblemId(id);

        return String.valueOf(helpRequests.size());
    }


}
