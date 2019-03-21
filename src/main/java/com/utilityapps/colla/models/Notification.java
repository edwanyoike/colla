package com.utilityapps.colla.models;

import com.utilityapps.colla.utilityclasses.NotificationType;
import org.springframework.data.annotation.Id;

public class Notification  {
    @Id
    private long id;

    private String notificationBody;

    private NotificationType notificationType;


}
