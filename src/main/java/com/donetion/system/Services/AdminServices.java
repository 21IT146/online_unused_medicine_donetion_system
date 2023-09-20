package com.donetion.system.Services;

import com.donetion.system.Entities.AdminLogin;
import com.donetion.system.Entities.Donetion;
import com.donetion.system.Repository.AdminRepository;
import com.donetion.system.Repository.DonetionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminServices {

    @Autowired
    private AdminRepository adminRepository;

    public List<AdminLogin> getAllAdmin(){
        List<AdminLogin> list=(List<AdminLogin>)this.adminRepository.findAll();
        return list;
    }
    public AdminLogin getAdmin(int id) {
        AdminLogin admin = adminRepository.findById(id);

        return admin;
    }

    //Adding the admin
    public AdminLogin addAdmin(AdminLogin b){
        AdminLogin result= adminRepository.save(b);
        return result;
    }
}
