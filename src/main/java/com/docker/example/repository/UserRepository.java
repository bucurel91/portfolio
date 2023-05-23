package com.docker.example.repository;

import com.docker.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

//    User findById(int id);
}
