package com.utilityapps.colla.controllers;

import com.utilityapps.colla.interfaces.CollaErrorI;
import com.utilityapps.colla.interfaces.UserServiceI;
import com.utilityapps.colla.models.CollaError;
import com.utilityapps.colla.services.CollaErrorService;
import com.utilityapps.colla.services.NextSequenceService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Optional;

@RestController
public class CollaErrorController {

    private final CollaErrorI collaErrorService;
    private final UserServiceI userService;
    private final NextSequenceService nextSequenceService;

    public CollaErrorController(CollaErrorService collaErrorService, UserServiceI userService, NextSequenceService nextSequenceService) {
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
        collaError.setCreateddBy(userService.findUserById((1L)).get());


        collaError.setId(nextSequenceService.getNextSequence("customSequences"));

        if(collaErrorService.save(collaError)!= null)
        {
            return "done";
        }
        return "not done";
    }


    @GetMapping(value = "/collaerror/{id}")
    public ModelAndView getRequestById(@PathVariable("id") long id, ModelAndView modelAndView ){

        Optional<CollaError> collaErrorOptional = collaErrorService.findById(id);

        if(collaErrorOptional.isPresent()) {
            modelAndView.addObject("collaerror", collaErrorOptional.get());
        } //TODO throw an exception if optional is empty


        modelAndView.setViewName("single-colla-error");

        return modelAndView;

    }
}
