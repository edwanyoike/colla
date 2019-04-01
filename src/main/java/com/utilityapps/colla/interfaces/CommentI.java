package com.utilityapps.colla.interfaces;

import com.utilityapps.colla.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentI {
    Comment save(Comment helpRequest);
    Optional<Comment> findById(long id);
    List<Comment> findAll();

}
