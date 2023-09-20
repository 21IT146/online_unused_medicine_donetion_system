package com.donetion.system.Services;

import com.donetion.system.Entities.Registration;
import com.donetion.system.Entities.UserLogin;
import com.donetion.system.Repository.RegistrationRepository;
import com.donetion.system.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<UserLogin> getAllUser(){
        List<UserLogin> list=(List<UserLogin>)this.userRepository.findAll();
        return list;
    }
    public UserLogin getUser(int id) {
        UserLogin user = userRepository.findById(id);
        return user;
    }

    //Adding the User
    public UserLogin adduser(UserLogin b){
        UserLogin result= userRepository.save(b);
        return result;
    }
}
