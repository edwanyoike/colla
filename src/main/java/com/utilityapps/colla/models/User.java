package com.utilityapps.colla.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ewanyoike
 */

@Getter
@Setter
@Document(collection = "user")
public class User {

    @Id
    private long id;

    private String username;
    private String password;

    @Override
    public String
    toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
