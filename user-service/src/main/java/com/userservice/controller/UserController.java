package com.userservice.controller;

import com.userservice.entity.UserEntity;
import com.userservice.entity.UserRequest;
import com.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/save")
    public ResponseEntity<UserEntity> save(@RequestBody UserRequest request) {

        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping("/find")
    public ResponseEntity<List<UserEntity>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
