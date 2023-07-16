package com.hems.springbackend.Service;

import com.hems.springbackend.Model.User;
import com.hems.springbackend.Repositry.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService{
    @Autowired
    UserRepo userRepo;
    public ArrayList<User> fetchService(){
        ArrayList<User> arr= (ArrayList<User>) userRepo.findAll();
        return arr;
    }


    public ArrayList<User> saveService(User user) {
//        user.setUser_id(UUID.randomUUID());
        userRepo.save(user);
        return fetchService();
    }
}
