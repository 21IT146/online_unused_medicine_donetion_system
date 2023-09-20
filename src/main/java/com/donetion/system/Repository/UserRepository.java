package com.donetion.system.Repository;

import com.donetion.system.Entities.UserLogin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserLogin,Integer> {
    public UserLogin findById(int id);
}
