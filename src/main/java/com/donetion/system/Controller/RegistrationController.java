package com.donetion.system.Controller;

import com.donetion.system.Entities.Registration;
import com.donetion.system.Repository.RegistrationRepository;
import com.donetion.system.Services.RegistrationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationServices registrationServices;

    @PostMapping("/Registration")
    public ResponseEntity<Registration> addRegistration(@RequestBody Registration registration){

        Registration b1=null;
        try {
            b1 = this.registrationServices.addRegistration(registration);
            System.out.println(registration);
            return ResponseEntity.of(Optional.of(b1));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/Registration")
    public ResponseEntity<List<Registration>> getregistration()
    {
        List<Registration> list= this.registrationServices.getAllRegistration();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    @GetMapping("/Registration/{name}")
    public ResponseEntity<Registration> getregistration(@PathVariable("name") String name)
    {

        Registration registration =registrationServices.getRegistration(name);

        if(registration ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(registration));
    }
}
