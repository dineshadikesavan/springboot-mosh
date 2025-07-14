package com.tsc.demo.controller;

import com.tsc.demo.entity.User;
import com.tsc.demo.exception.UserNotFoundException;
import com.tsc.demo.model.UserVO;
import com.tsc.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(MessageSource messageSource, UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<User> getUsers() {
        User user = User.builder().userId(1L).email("dinesh.adi@gmail.com").name("Dinesh").password("password").phoneNumber("6292446633").build();
        //URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").buildAndExpand(user.getUserId()).toUri();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/all-users")
    public List<UserVO> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserVO> getUser(@PathVariable Long id) throws UserNotFoundException {
        UserVO userVO = userService.getUser(id);

        if (userVO == null) {
            throw new UserNotFoundException("id:" + id);
        }
        return new ResponseEntity<UserVO>(userVO, HttpStatus.OK);
    }

    @GetMapping("/users/hateoas/{id}")
    public EntityModel<UserVO> getUserHateoas(@PathVariable Long id) throws UserNotFoundException {
        UserVO userVO = userService.getUser(id);

        if (userVO == null) {
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<UserVO> entityModel = EntityModel.of(userVO);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

}
