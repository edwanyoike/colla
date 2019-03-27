package com.utilityapps.colla.services;

import com.utilityapps.colla.interfaces.CollaErrorI;
import com.utilityapps.colla.models.CollaError;
import com.utilityapps.colla.models.User;
import com.utilityapps.colla.repositories.CollaErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaErrorService implements CollaErrorI {

    private final CollaErrorRepository collaErrorRepository;

    @Autowired
    public CollaErrorService(CollaErrorRepository collaErrorRepository) {
        this.collaErrorRepository = collaErrorRepository;
    }

    @Override
    public List<CollaError> findAll() {
        return collaErrorRepository.findAll();
    }

    @Override
    public CollaError findById(long id) {
        return collaErrorRepository.findById(id);
    }

    @Override
    public CollaError save(CollaError collaError) {
        return collaErrorRepository.save(collaError);
    }

    @Override
    public List<CollaError> findByUser(User user) {
        return collaErrorRepository.findByCreateddBy(user);
    }

    @Override
    public List<CollaError> findSolvedOnes() {
        return collaErrorRepository.findBySolved();
    }
}
