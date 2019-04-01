package com.utilityapps.colla.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter @Setter
@Document(collection = "Comment")

public class Comment {

    @Id
    private Long id;

    private String commentBody;
    private List<Comment> replies;
    private boolean visible;
    private boolean deleted;
    private User createdBy;
    private Date dateCreated;


    public Comment(Long id, String commentBody, boolean visible,Date date) {
        this.id = id;
        this.commentBody = commentBody;
        this.visible = visible;
        this.dateCreated = date;
    }
}
