package com.utilityapps.colla.controllers;

import com.utilityapps.colla.interfaces.NextSequenceServiceI;
import com.utilityapps.colla.interfaces.NotificationI;
import com.utilityapps.colla.models.Notification;
import com.utilityapps.colla.models.User;
import com.utilityapps.colla.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class NotificationController {

    private final NextSequenceServiceI nextSequenceService;
    private final NotificationI notificationService;
    private final UserService userService;

    public NotificationController(NextSequenceServiceI nextSequenceService, NotificationI notificationService, UserService userService) {
        this.nextSequenceService = nextSequenceService;
        this.notificationService = notificationService;
        this.userService = userService;
    }

    @PostMapping("/notification")
    public String createUser(@RequestBody Notification notification, HttpServletRequest request) {

        notification.setId(nextSequenceService.getNextSequence("customSequences"));
        notification.setDate(new Date());
//        Long id  = Long.valueOf( request.getSession(false).getAttribute("id").toString() );
        User user = userService.findUserById(1L).get();
        notification.setCreatedBy(user);

        if (notificationService.save(notification) != null) {
            return "done";

        } else
            return "not done";

    }

    @GetMapping(value = "/notification")
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<Notification> notifications = notificationService.findAll();
        modelAndView.addObject("notifications", notifications);
        modelAndView.setViewName("notifications"); //TODO make this view

        return modelAndView;
    }

    @GetMapping(value = "/notification/{id}")
    public ModelAndView getAll(@PathVariable("id") long id, ModelAndView modelAndView) {
        Optional<Notification> notificationOptional = notificationService.findById(id);

        if (notificationOptional.isPresent()) {
            modelAndView.addObject("notification", notificationOptional.get());

        }

        modelAndView.setViewName("notification");

        return modelAndView;
    }

    @GetMapping(value = "/usernotification")
    public ModelAndView getAllPerUser(@PathVariable("id") Long id, ModelAndView modelAndView) {
        List<Notification> notifications = notificationService.getAllPerUser(id);
        modelAndView.addObject("notifications", notifications);
        modelAndView.setViewName("notifications"); //TODO make this view

        return modelAndView;
    }

    @GetMapping(value = "/seennotification")
    public ModelAndView getSeenNotification(ModelAndView modelAndView, HttpServletRequest request) {
        Long id = Long.valueOf(request.getSession(false).getAttribute("user_id").toString());
        User user = userService.findUserById(id).get();

        List<Notification> notifications = notificationService.findSeenNotifications(id);
        modelAndView.addObject("notifications", notifications);
        modelAndView.setViewName("notifications"); //TODO make this view

        return modelAndView;
    }


    @GetMapping(value = "/unseennotification")
    public ModelAndView getUnseenNotification(ModelAndView modelAndView, HttpServletRequest request) {
        Long id = Long.valueOf(request.getSession(false).getAttribute("user_id").toString());
        User user = userService.findUserById(id).get();

        List<Notification> notifications = notificationService.findUnseenNotifications(id);
        modelAndView.addObject("notifications", notifications);
        modelAndView.setViewName("notifications"); //TODO make this view

        return modelAndView;
    }


    public ModelAndView getSingleNotification(@PathParam("id") Long id, ModelAndView modelAndView, HttpServletRequest request) {

        Optional<Notification> notificationOptional = notificationService.findById(id);
        if (notificationOptional.isPresent()) {
            modelAndView.addObject("notifications", notificationOptional.get());
        } else {
            modelAndView.addObject("Zeronotifications", "you have no notifications here");
        }

        modelAndView.setViewName("notifications"); //TODO make this view

        return modelAndView;
    }


}
