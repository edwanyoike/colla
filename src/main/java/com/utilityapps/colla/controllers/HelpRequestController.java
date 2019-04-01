package com.utilityapps.colla.controllers;


import com.utilityapps.colla.interfaces.HelpRequestI;
import com.utilityapps.colla.interfaces.NextSequenceServiceI;
import com.utilityapps.colla.interfaces.UserServiceI;
import com.utilityapps.colla.models.CollaError;
import com.utilityapps.colla.models.HelpRequest;
import com.utilityapps.colla.services.CollaErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class HelpRequestController {
    private final HelpRequestI helpRequestService;
    private final NextSequenceServiceI nextSequenceService;
    private final UserServiceI userService;
    private final CollaErrorService collaProblemService;

    @Autowired
    public HelpRequestController(HelpRequestI helpRequestService, NextSequenceServiceI nextSequenceService, UserServiceI userService, CollaErrorService collaProblemService) {
        this.helpRequestService = helpRequestService;

        this.nextSequenceService = nextSequenceService;
        this.userService = userService;
        this.collaProblemService = collaProblemService;
    }

    @PostMapping("/helprequest")
    public String createRequest(@RequestBody HelpRequest helpRequest, HttpSession session){

        helpRequest.setDateCreated(new Date());
//        long id  = Long.valueOf( session.getAttribute("id").toString() );
        helpRequest.setFrom(userService.findUserById((1L)).get());
       CollaError collaError =  collaProblemService.findById(4L).get(); //TODO add option.ispresent() check
       helpRequest.setCollaError(collaError);

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
    public ModelAndView getRequestById(@PathVariable("id") long id,ModelAndView modelAndView ){

        Optional <HelpRequest> helpRequestOptional = helpRequestService.findById(id);
        if(helpRequestOptional.isPresent()) {
            modelAndView.addObject("request", helpRequestOptional.get());
        } //TODO throw an exception if optional is empty

        System.out.println("this is the retrieved request by help request controller "+ helpRequestOptional.get().getId());
        System.out.println("this is the retrieved request by help request error controller "+ helpRequestOptional.get().getCollaError().getId());

        modelAndView.setViewName("helprequest");

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
