package com.utilityapps.colla.controllers;

import com.utilityapps.colla.interfaces.CollaErrorI;
import com.utilityapps.colla.interfaces.CommentI;
import com.utilityapps.colla.interfaces.UserServiceI;
import com.utilityapps.colla.models.CollaError;
import com.utilityapps.colla.models.Comment;
import com.utilityapps.colla.models.User;
import com.utilityapps.colla.services.NextSequenceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@RequestMapping
public class CommentController {

    private final CollaErrorI collaErrorService;
    private final CommentI commentService;
    private final UserServiceI userService;
    private final NextSequenceService nextSequenceService;


    public CommentController(CollaErrorI collaErrorService, CommentI commentService, UserServiceI userService, NextSequenceService nextSequenceService) {
        this.collaErrorService = collaErrorService;
        this.commentService = commentService;
        this.userService = userService;
        this.nextSequenceService = nextSequenceService;
    }

    @PostMapping("/comment")
    public ModelAndView Commentpersist(@PathParam("collaErrorId") long id, @PathParam("comment") String comment, HttpSession session, HttpServletResponse response) {
        Optional<CollaError> collaErrorOptional = collaErrorService.findById(id);

        if (collaErrorOptional.isPresent()) {

            Long commentId = nextSequenceService.getNextSequence("customSequences");

            CollaError collaError = collaErrorOptional.get();
            Comment persistedComment = persistComment(new Comment(commentId,comment,true, new Date()),session);

            if(persistedComment !=null){
                collaError.getComments().add(persistedComment);
            }


        }

        return new ModelAndView("redirect:" + "collaerror", "id", id);


    }

    private Comment persistComment(Comment comment,HttpSession session)
    {
        Optional<User> userOptional  =  userService.findUserById(Long.valueOf(session.getAttribute("id").toString()));

        if(userOptional.isPresent())
        {
            comment.setCreatedBy(userOptional.get());
            return commentService.save(comment);
        }
        return null;

    }

}
