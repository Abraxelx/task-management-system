package com.taskmanagement.mongo.api.controller;

import com.taskmanagement.mongo.api.model.User;
import com.taskmanagement.mongo.api.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@Controller
public class UserController {

    @Autowired
    private UsersRepository repository;

    @PostMapping(value = "/addUser")
    public String saveUser(@RequestBody User user){
        repository.save(user);
        return "Added users with name: " +user.getFirstName() + user.getLastName();
    }

    @GetMapping("/findUsers")
    public List<User> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/findUserById/{id}")
    public Optional<User> getUser(@PathVariable int id){
        return repository.findById(id);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public String deleteUser(@PathVariable int id){
        repository.deleteById(id);
        return "User deleted with id : " + id;
    }

}
