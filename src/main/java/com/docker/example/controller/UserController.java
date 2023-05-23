package com.docker.example.controller;

import com.docker.example.model.User;
import com.docker.example.service.UserService;
import com.docker.example.service.obj.CreateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody CreateUser createUser) {
        User user = service.createUser(createUser);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        return ResponseEntity.ok(service.getUser(id));
    }
}
