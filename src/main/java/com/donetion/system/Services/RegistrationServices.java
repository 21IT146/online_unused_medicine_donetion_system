package com.donetion.system.Services;

import com.donetion.system.Entities.AdminLogin;
import com.donetion.system.Entities.Registration;
import com.donetion.system.Repository.AdminRepository;
import com.donetion.system.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistrationServices {

    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Registration> getAllRegistration(){
        List<Registration> list=(List<Registration>)this.registrationRepository.findAll();
        return list;
    }
    public Registration getRegistration(String username) {
        Registration registration = registrationRepository.findByUsernameLike(username);

        return registration;
    }

    //Adding the Registartion
    public Registration addRegistration(Registration b){
        Registration result= registrationRepository.save(b);
        return result;
    }
}
