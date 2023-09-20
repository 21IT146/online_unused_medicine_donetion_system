package com.donetion.system.Services;

import com.donetion.system.Entities.Donetion;
import com.donetion.system.Repository.DonetionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DonetionServices {

    @Autowired
    private DonetionRepository donetionRepository;

    public List<Donetion> getAllDonetion(){
        List<Donetion> list=(List<Donetion>)this.donetionRepository.findAll();
        return list;
    }
    public Donetion getMedicineName(String name) {
        Donetion donetion = donetionRepository.findByMedicinesNameLike(name);

        return donetion;
    }

    //Adding the book
    public Donetion addDonetion(Donetion b){
        Donetion result=donetionRepository.save(b);
        return result;
    }
}
