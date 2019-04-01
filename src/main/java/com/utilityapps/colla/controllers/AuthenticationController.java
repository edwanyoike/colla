package com.utilityapps.colla.controllers;


import com.utilityapps.colla.models.CollaError;
import com.utilityapps.colla.models.HelpRequest;
import com.utilityapps.colla.models.User;
import com.utilityapps.colla.services.CollaErrorService;
import com.utilityapps.colla.services.HelpRequestService;
import com.utilityapps.colla.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AuthenticationController {

    private final CollaErrorService collaProblemService;
    private final UserService userService;
    private final HelpRequestService helpRequestService;

    public AuthenticationController(CollaErrorService problemService, UserService userService, HelpRequestService helpRequestService) {
        this.collaProblemService = problemService;
        this.userService = userService;

        this.helpRequestService = helpRequestService;
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request)
    {
        System.out.println("login called by "+request.getRequestURI());

        if ( null == request.getSession(false) || request.getSession(false).getAttribute("id") == null ) {
            System.out.println("no valid session so i am in here");

            modelAndView.setViewName("login");
            return modelAndView;
        }

        modelAndView.setViewName("index");
        return prepareDashboard(modelAndView,request);
    }


    // Login form with error
    @RequestMapping("/login-error")
    public ModelAndView loginError(ModelAndView modelAndView) {
        System.out.println("login errror calleld");

        modelAndView.addObject("loginError", "wrong values");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/success")
    public ModelAndView loginSuccessful(ModelAndView modelAndView, HttpServletRequest request){

        System.out.println("success calleld");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username  //TODO find how to get ID

        User user = userService.findUserByUsername(name);

        request.getSession(true).setAttribute("id",user.getId());


        modelAndView.setViewName("index");
        return prepareDashboard(modelAndView,request);
    }



        @RequestMapping(value = "/x",method= RequestMethod.GET)
        public ModelAndView logout(HttpSession session,ModelAndView modelAndView) {
            System.out.println("log out called");
        session.removeAttribute("id");


        session.invalidate();

        modelAndView.setViewName("redirect:login");
        return modelAndView;
        }


    private ModelAndView prepareDashboard(ModelAndView modelAndView, HttpServletRequest request)
    {
        System.out.println("prepare dashboard called");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username  //TODO find how to get ID
        User user = userService.findUserById( Long.parseLong( request.getSession(false).getAttribute("id").toString() ) ).get();

        List<CollaError> loggedIssues = collaProblemService.findAll();

        List<HelpRequest> helprequest = helpRequestService.findByFrom(user.getId());  //TODO this repo  method should take a user object

        modelAndView.addObject("loggedIssues",loggedIssues);
        modelAndView.addObject("helprequest",helprequest);
        return modelAndView;
    }


}
