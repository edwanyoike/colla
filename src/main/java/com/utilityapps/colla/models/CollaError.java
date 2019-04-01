package com.utilityapps.colla.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * @author ewanyoike
 */


@Getter
@Setter
@Document(collection = "collaError")
public class CollaError {

    @Id
    private long id;

    private String description;

    private String errorSnipet;

    private Date dateCreated;

    private int encounteredTimes;

    private User createddBy;

    private boolean solved;

    private String solution;

    private List<Comment> comments;



    //TODO add comments
    //TODO add  solvedby

}
