package com.docker.example.service;

import com.docker.example.model.User;
import com.docker.example.repository.UserRepository;
import com.docker.example.service.obj.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUser createUser) {
        User user = createUser.toEntity();
        userRepository.save(user);
        return user;
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow();
    }
}
