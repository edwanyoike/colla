package com.utilityapps.colla.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @GetMapping(value = {"/login","/"})
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request)
    {
        if (request.getSession(false) == null) {
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    // Login form with error
    @RequestMapping("/login-error")
    public ModelAndView loginError(ModelAndView modelAndView) {

        modelAndView.addObject("loginError", "wrong values");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/success")
    public ModelAndView loginSuccessful(ModelAndView modelAndView){

        modelAndView.setViewName("index");
        return modelAndView;
    }


}
