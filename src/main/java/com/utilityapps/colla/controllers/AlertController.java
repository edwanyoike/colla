package com.utilityapps.colla.controllers;


import com.utilityapps.colla.models.HelpRequest;
import com.utilityapps.colla.models.Notification;
import com.utilityapps.colla.services.HelpRequestService;
import com.utilityapps.colla.services.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AlertController {
    private final HelpRequestService helpRequestService;
    private final NotificationService notificationService;

    public AlertController(HelpRequestService helpRequestService, NotificationService notificationService) {
        this.helpRequestService = helpRequestService;
        this.notificationService = notificationService;
    }


    @GetMapping("/alerts")
    public ModelAndView getAlerts(ModelAndView modelAndView, HttpServletRequest request){
        modelAndView.setViewName("alerts");
        Long id  = Long.valueOf( request.getSession(false).getAttribute("id").toString() );
        List<Notification> notification = notificationService.findAll();
        List<HelpRequest> helpRequest = helpRequestService.findByCollaProblem_CreateddBy_Id(id);

        modelAndView.addObject("notificationcount",notification.size());
        modelAndView.addObject("requestcount",helpRequest.size());
        modelAndView.addObject("notification",notification);
        modelAndView.addObject("helpRequest",helpRequest);
        return modelAndView;
    }
}
