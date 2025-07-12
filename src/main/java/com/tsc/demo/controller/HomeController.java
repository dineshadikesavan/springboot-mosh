package com.tsc.demo.controller;

import com.tsc.demo.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class HomeController {

    @GetMapping("/users")
    public ResponseEntity<User> getUsers() {
        User user = new User();
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").buildAndExpand(user.getUserId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
