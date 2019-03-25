package com.utilityapps.colla.interfaces;

import com.utilityapps.colla.models.Notification;

import java.util.List;

public interface NotificationI {

    Notification save(Notification notification);

    List findAll();


}
