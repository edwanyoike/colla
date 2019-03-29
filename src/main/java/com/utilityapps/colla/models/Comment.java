package com.utilityapps.colla.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Document(collection = "Comment")

public class Comment {

    @Id
    private Long id;

    private String commentBody;
    private List<Comment> replies;
    private boolean visible;
    private boolean deleted;



}
