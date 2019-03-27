package com.utilityapps.colla.interfaces;

import com.utilityapps.colla.models.CollaError;
import com.utilityapps.colla.models.User;

import java.util.List;

public interface CollaErrorI {
    List<CollaError> findAll();
    CollaError findById(long id);
    CollaError save(CollaError collaError);
    List<CollaError> findByUser(User user);
    List<CollaError> findSolvedOnes();
}
