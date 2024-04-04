package com.lql.springdemo.controller;


import com.lql.springdemo.model.User;
import com.lql.springdemo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUserName(username);
    }

    @PostMapping
    public User create(@RequestBody @Valid User user) {
        return userService.save(user);
    }
}
