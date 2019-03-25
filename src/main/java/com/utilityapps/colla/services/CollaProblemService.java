package com.utilityapps.colla.services;

import com.utilityapps.colla.interfaces.CollaProblemI;
import com.utilityapps.colla.models.CollaProblem;
import com.utilityapps.colla.models.User;
import com.utilityapps.colla.repositories.CollaProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaProblemService implements CollaProblemI {

    private final CollaProblemRepository collaProblemRepository;

    @Autowired
    public CollaProblemService(CollaProblemRepository collaProblemRepository) {
        this.collaProblemRepository = collaProblemRepository;
    }

    @Override
    public List<CollaProblem> findAll() {
        return collaProblemRepository.findAll();
    }

    @Override
    public CollaProblem findById(long id) {
        return null;
    }

    @Override
    public List<CollaProblem> findByUser(User user) {
        return null;
    }

    @Override
    public List<CollaProblem> findSolvedOnes() {
        return null;
    }
}
