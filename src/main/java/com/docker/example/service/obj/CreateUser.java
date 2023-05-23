package com.docker.example.service.obj;

import com.docker.example.model.User;

import java.util.UUID;

public class CreateUser {

    private String id;
    private final String firstName;
    private final String secondName;

    public CreateUser(String id, String firstName, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public User toEntity() {
        id = UUID.randomUUID().toString();
        return new User(id, firstName, secondName);
    }
}
