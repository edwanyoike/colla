package com.utilityapps.colla.interfaces;

import com.utilityapps.colla.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserServiceI {

    User save(User user);

    List findAll();

    User findUserByUsername(String uname);

}
