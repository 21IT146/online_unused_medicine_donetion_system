package com.donetion.system.Controller;

import com.donetion.system.Entities.AdminLogin;
import com.donetion.system.Repository.AdminRepository;
import com.donetion.system.Services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminServices adminServices;

    @PostMapping("/admin")
    public ResponseEntity<AdminLogin> addAdmin(@RequestBody AdminLogin adminLogin){

        AdminLogin b1=null;
        try {
            b1 = this.adminServices.addAdmin(adminLogin);
            System.out.println(adminLogin);
            return ResponseEntity.of(Optional.of(b1));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/admin")
    public ResponseEntity<List<AdminLogin>> getadmin()
    {
        List<AdminLogin> list= this.adminServices.getAllAdmin();
        if(list.size()<=0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }
    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminLogin> getadmin(@PathVariable("id") int id)
    {

        AdminLogin adminlogin=adminServices.getAdmin(id);

        if(adminlogin ==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(adminlogin));
    }
}
