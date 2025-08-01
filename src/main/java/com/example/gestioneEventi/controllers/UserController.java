package com.example.gestioneEventi.controllers;

import com.example.gestioneEventi.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.gestioneEventi.payloads.NewUserDto;
import com.example.gestioneEventi.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findall();
    }
    @PostMapping
    public User createUser(@Valid @RequestBody NewUserDto userDto) {
        return userService.addUser(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {

        userService.delete(id);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable long id) {
        return userService.findById(id);
    }


}
