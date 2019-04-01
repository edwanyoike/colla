package com.utilityapps.colla.repositories;

import com.utilityapps.colla.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends MongoRepository<Comment,Long> {

}
