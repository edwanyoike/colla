package com.utilityapps.colla.services;

import com.utilityapps.colla.interfaces.NotificationI;
import com.utilityapps.colla.models.Notification;
import com.utilityapps.colla.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements NotificationI {

    private final NotificationRepository notificationRepository;


    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    @Override
    public Notification save(Notification notification) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }
}
