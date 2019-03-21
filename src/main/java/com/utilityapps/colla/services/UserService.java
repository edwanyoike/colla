package com.utilityapps.colla.services;

import com.utilityapps.colla.interfaces.UserServiceI;
import com.utilityapps.colla.models.User;
import com.utilityapps.colla.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceI {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String uname) {

        return userRepository.findUserByUsername(uname);
    }
}
