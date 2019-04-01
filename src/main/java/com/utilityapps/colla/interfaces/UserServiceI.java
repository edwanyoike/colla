package com.utilityapps.colla.interfaces;

import com.utilityapps.colla.models.User;

import java.util.List;
import java.util.Optional;


public interface UserServiceI {

    User save(User user);

    List findAll();

    User findUserByUsername(String uname);
    Optional<User> findUserById(Long id);

}
