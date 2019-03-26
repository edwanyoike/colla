package com.utilityapps.colla.models;

import com.utilityapps.colla.utilityclasses.NotificationType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "notification")
public class Notification  {
    @Id
    private long id;

    private String notificationBody;

    private NotificationType notificationType;

    private Long ownerId;

    private Boolean seen;

    private Date date;


}
