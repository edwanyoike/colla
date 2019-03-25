package com.utilityapps.colla.services;

import com.utilityapps.colla.interfaces.NotificationI;
import com.utilityapps.colla.models.Notification;
import com.utilityapps.colla.models.User;
import com.utilityapps.colla.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements NotificationI {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    @Override
    public Notification save(Notification notification) {

        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findAll() {

        return notificationRepository.findAll();
    }

    @Override
    public List<Notification> getAllPerUser(Long id) {
        return notificationRepository.findAllByOwner_Id(id);
    }

    @Override
    public List<Notification> findSeenNotifications(User user) {
        return notificationRepository.findAllByOwnerAndSeenIsTrue(user);
    }

    @Override
    public List<Notification> findUnseenNotifications(User user) {
        return notificationRepository.findAllByOwnerAndSeenIsFalse(user);
    }
}
