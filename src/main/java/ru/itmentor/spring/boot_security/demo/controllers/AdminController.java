package ru.itmentor.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
    @GetMapping("/users/{id}")
    public User getUserbyId(@PathVariable int id) {
        return userService.findUserById(id);
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
    @PutMapping("/users/{id}")
    public User updatedUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

}
