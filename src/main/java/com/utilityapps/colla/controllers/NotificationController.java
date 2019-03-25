package com.utilityapps.colla.controllers;

import com.utilityapps.colla.interfaces.NextSequenceServiceI;
import com.utilityapps.colla.interfaces.NotificationI;
import com.utilityapps.colla.models.Notification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class NotificationController {

    private final NextSequenceServiceI nextSequenceService;
    private final NotificationI notificationService;

    public NotificationController(NextSequenceServiceI nextSequenceService, NotificationI notificationService) {
        this.nextSequenceService = nextSequenceService;
        this.notificationService = notificationService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody Notification notification){

        notification.setId(nextSequenceService.getNextSequence("customSequences"));

        if(notificationService.save(notification) != null) {
            return "done";

        }
        else
            return "not done";

    }
}
