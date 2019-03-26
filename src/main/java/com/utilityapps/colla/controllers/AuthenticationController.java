package com.utilityapps.colla.controllers;


import com.utilityapps.colla.models.CollaProblem;
import com.utilityapps.colla.models.HelpRequest;
import com.utilityapps.colla.models.User;
import com.utilityapps.colla.services.CollaProblemService;
import com.utilityapps.colla.services.HelpRequestService;
import com.utilityapps.colla.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AuthenticationController {

    private final CollaProblemService collaProblemService;
    private final UserService userService;
    private final HelpRequestService helpRequestService;

    public AuthenticationController(CollaProblemService problemService, UserService userService, HelpRequestService helpRequestService) {
        this.collaProblemService = problemService;
        this.userService = userService;

        this.helpRequestService = helpRequestService;
    }

    @GetMapping(value = {"/login","/"})
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request)
    {
        if (request.getSession(false) == null || request.getSession(false).getAttribute("id") == null) {
            modelAndView.setViewName("login");
            return modelAndView;
        }

        modelAndView.setViewName("index");
        return prepareDashboard(modelAndView,request);
    }


    // Login form with error
    @RequestMapping("/login-error")
    public ModelAndView loginError(ModelAndView modelAndView) {

        modelAndView.addObject("loginError", "wrong values");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/success")
    public ModelAndView loginSuccessful(ModelAndView modelAndView,HttpServletRequest request){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username  //TODO find how to get ID
        User user = userService.findUserByUsername(name);

        request.getSession(true).setAttribute("id",user.getId());
        modelAndView.setViewName("index");
        return prepareDashboard(modelAndView,request);
    }

    private ModelAndView prepareDashboard(ModelAndView modelAndView,HttpServletRequest request)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username  //TODO find how to get ID
        User user = userService.findUserById( Long.parseLong( request.getSession(false).getAttribute("id").toString() ) );

        List<CollaProblem> loggedIssues = collaProblemService.findByUser(user);

        List<HelpRequest> helprequest = helpRequestService.findByFrom(user.getId());  //TODO this repo  method should take a user object

        modelAndView.addObject("loggedIssues",loggedIssues);
        modelAndView.addObject("helprequest",helprequest);
        return modelAndView;
    }


}
