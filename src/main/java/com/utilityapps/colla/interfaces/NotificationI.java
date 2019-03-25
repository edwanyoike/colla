package com.utilityapps.colla.interfaces;

import com.utilityapps.colla.models.Notification;
import com.utilityapps.colla.models.User;

import java.util.List;

public interface NotificationI {

    Notification save(Notification notification);

    List<Notification> findAll();
    List<Notification> getAllPerUser(Long id);

    List<Notification> findSeenNotifications(User user);
    List<Notification> findUnseenNotifications(User user);




}
