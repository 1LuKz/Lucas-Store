package com.lucasstore.store.controllers;

import com.lucasstore.store.models.User;
import com.lucasstore.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User myUser = new User(1, "Lucas", "lucas@email.com", "31988335566", "myPassword123");
        return ResponseEntity.status(HttpStatus.OK).body(myUser);
    }
}
