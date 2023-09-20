package com.donetion.system.Repository;


import com.donetion.system.Entities.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistrationRepository extends MongoRepository<Registration,Integer> {
    public Registration findByUsernameLike(String Username);
}
