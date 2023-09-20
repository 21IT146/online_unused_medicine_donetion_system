package com.donetion.system.Repository;

import com.donetion.system.Entities.AdminLogin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<AdminLogin,Integer> {

    public AdminLogin findById(int id);
}
