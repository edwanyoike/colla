package com.utilityapps.colla.interfaces;

import com.utilityapps.colla.models.CollaProblem;
import com.utilityapps.colla.models.User;

import java.util.List;

public interface CollaProblemI {
    List<CollaProblem> findAll();
    CollaProblem findById(long id);
    List<CollaProblem> findByUser(User user);
    List<CollaProblem> findSolvedOnes();
}
