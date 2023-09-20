package com.donetion.system.Controller;

import com.donetion.system.Entities.Donetion;
import com.donetion.system.Repository.DonetionRepository;
import com.donetion.system.Services.DonetionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DonetionController {

    @Autowired
    private DonetionRepository donetionRepository;

    @Autowired
    private DonetionServices donetionServices;

    @PostMapping("/donetion")
    public ResponseEntity<Donetion> addDonetion(@RequestBody Donetion donetion){

        Donetion b1=null;
        try {
            b1 = this.donetionServices.addDonetion(donetion);
            System.out.println(donetion);
            return ResponseEntity.of(Optional.of(b1));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/donetion")
    public ResponseEntity<List<Donetion>> getdonetion()
    {
        List<Donetion> list= this.donetionServices.getAllDonetion();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    @GetMapping("/donetion/{name}")
    public ResponseEntity<Donetion> getdonetion(@PathVariable("name") String name)
    {

        Donetion donetion =donetionServices.getMedicineName(name);

        if(donetion ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(donetion));
    }

}
