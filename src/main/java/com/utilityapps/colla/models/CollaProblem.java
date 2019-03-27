package com.utilityapps.colla.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author ewanyoike
 */


@Getter
@Setter
@Document(collection = "collaProblemId")
public class CollaProblem {

    @Id
    private long id;

    private String description;

    private String errorSnipet;

    private Date dateCreated;

    private int encounteredTimes;

    private User createddBy;

    private boolean solved;

}
