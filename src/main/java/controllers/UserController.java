package controllers;

import entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import payloads.NewUserDto;
import services.UserService;

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
    public User getById(@PathVariable String mail) {
        return userService.findByEmail(mail);
    }


}
