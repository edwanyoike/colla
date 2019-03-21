package com.utilityapps.colla.controllers;


import com.utilityapps.colla.interfaces.NextSequenceServiceI;
import com.utilityapps.colla.interfaces.UserServiceI;
import com.utilityapps.colla.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceI userService;
    private final NextSequenceServiceI nextSequenceService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserController(UserServiceI userService, NextSequenceServiceI nextSequenceService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.nextSequenceService = nextSequenceService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user){

        user.setId(nextSequenceService.getNextSequence("customSequences"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        if(userService.save(user) != null) {
            return "done";

        }
        else
            return "not done";

    }

    @GetMapping("/user")
    List findAll()
    {
        return userService.findAll();
    }
}
