package com.donetion.system.Controller;

import com.donetion.system.Entities.Donetion;
import com.donetion.system.Entities.UserLogin;
import com.donetion.system.Repository.DonetionRepository;
import com.donetion.system.Repository.UserRepository;
import com.donetion.system.Services.DonetionServices;
import com.donetion.system.Services.UserServices;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<UserLogin> addUser(@RequestBody UserLogin userLogin){

        UserLogin b1=null;
        try {
            b1 = this.userServices.adduser(userLogin);
            System.out.println(userLogin);
            return ResponseEntity.of(Optional.of(b1));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/user")
    public ResponseEntity<List<UserLogin>> getUser()
    {
        List<UserLogin> list= this.userServices.getAllUser();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserLogin> getuser(@PathVariable("id") int id)
    {

        UserLogin userLogin =userServices.getUser(id);

        if(userLogin ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(userLogin));
    }
}
