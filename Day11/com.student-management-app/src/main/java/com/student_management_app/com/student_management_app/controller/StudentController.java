package com.student_management_app.com.student_management_app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")

public class StudentController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/read")
    public Iterable<User> read() {
        return userRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody final User student) {
        System.out.println("Saving user: " + user);
        userRepository.save(user);
        return "save";
    }
}


