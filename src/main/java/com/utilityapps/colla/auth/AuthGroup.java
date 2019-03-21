package com.utilityapps.colla.auth;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "authgroup")
public class AuthGroup {
    @Id
    private long id;

    private String username;
    private String authGroup;

}
