package com.utilityapps.colla.controllers;

import com.utilityapps.colla.interfaces.UserServiceI;
import com.utilityapps.colla.models.CollaError;
import com.utilityapps.colla.services.CollaErrorService;
import com.utilityapps.colla.services.NextSequenceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class CollaProblemController {

    private final CollaErrorService collaErrorService;
    private final UserServiceI userService;
    private final NextSequenceService nextSequenceService;

    public CollaProblemController(CollaErrorService collaErrorService, UserServiceI userService, NextSequenceService nextSequenceService) {
        this.collaErrorService = collaErrorService;
        this.userService = userService;
        this.nextSequenceService = nextSequenceService;
    }

    @PostMapping(value = "/collaerror")
    public String createError(@RequestBody CollaError collaError, HttpSession session)
    {
        collaError.setDateCreated(new Date());
        System.out.println(session.toString()+",.......................");
//        long id  = Long.valueOf( session.getAttribute("id").toString() );
        collaError.setCreateddBy(userService.findUserById((7L)));


        collaError.setId(nextSequenceService.getNextSequence("customSequences"));

        if(collaErrorService.save(collaError)!= null)
        {
            return "done";
        }
        return "not done";
    }
}
