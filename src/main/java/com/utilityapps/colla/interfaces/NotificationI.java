package com.utilityapps.colla.interfaces;

import com.utilityapps.colla.models.Notification;
import com.utilityapps.colla.models.User;

import java.util.List;
import java.util.Optional;

public interface NotificationI {

    Notification save(Notification notification);

    List<Notification> findAll();
    List<Notification> getAllPerUser(Long id);

    List<Notification> findSeenNotifications(Long userId);
    List<Notification> findUnseenNotifications(Long userId);
    Optional<Notification> findById(Long aLong);




}
