package com.utilityapps.colla.models;

import com.utilityapps.colla.utilityclasses.NotificationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "notification")
public class Notification  {
    @Id
    private long id;

    private String notificationBody;

    private NotificationType notificationType;

    private User owner;

    private Boolean seen;


}
