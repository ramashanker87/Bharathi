package com.bharathi.app.patient_management_app.controller;

public class PatientManagement {
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/patient")

    public class patientController {

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

}
