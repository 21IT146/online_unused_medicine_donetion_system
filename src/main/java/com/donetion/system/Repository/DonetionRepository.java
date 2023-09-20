package com.donetion.system.Repository;

import com.donetion.system.Entities.Donetion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonetionRepository extends MongoRepository<Donetion,Integer> {

    public Donetion findByMedicinesNameLike(String name);
}
