package com.utilityapps.colla.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author ewanyoike
 */

@Getter
@Setter
@Document(collection = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    private String username;


    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
