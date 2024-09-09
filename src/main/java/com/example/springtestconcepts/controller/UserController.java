package com.example.springtestconcepts.controller;

import com.example.springtestconcepts.dto.UserRequest;
import com.example.springtestconcepts.dto.UserResponse;
import com.example.springtestconcepts.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse saveUser(@RequestBody UserRequest userRequest) {
        return userService.addUser(userRequest);
    }
}
