package com.utilityapps.colla.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "HelpRequest")
public class HelpRequest {

    @Id
    private long id;

    private User from;
    private String message;
    private Long collaProblemId;
    private boolean seen;
    private Date dateCreated;

    @Override
    public String toString() {
        return "HelpRequest{" +
                "id=" + id +
                ", from=" + from +
                ", message='" + message + '\'' +
                ", collaProblemId=" + collaProblemId +
                ", seen=" + seen +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
