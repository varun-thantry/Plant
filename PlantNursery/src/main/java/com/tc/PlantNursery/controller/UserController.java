package com.tc.PlantNursery.controller;

import com.tc.PlantNursery.entity.User;
import com.tc.PlantNursery.repository.UserRepo;
import com.tc.PlantNursery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepository;



//    @GetMapping("/user/customer")
//    public String welcome(Authentication authentication){
//        String userEmail = authentication.getName();
//
//        // Fetch user details from the database using the email
//        User user = userRepository.findByEmail(userEmail);
//
//        if (user != null) {
//            // You can now use the user object to get other details
//            String userName = user.getUserName();
//            String role = user.getRole();
//            Long id = user.getUid();
//
//            return "Welcome " + role + " - " + userName + " - " +id;
//        } else {
//            return "User not found";
//        }
//    }
//
//    @GetMapping("/admin")
//    public String adminWelcome(){
//        return "Welcome admin";
//    }
//
//    @GetMapping("/")
//    public String allWelcome(){
//        return "Welcome all";
//    }

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public Object validateLogin(@RequestBody HashMap<String, Object> userDetails) {
        String userName = userDetails.get("username").toString();
        String password = userDetails.get("password").toString();

        User foundUser = userService.validateUserLogin(userName, password);

        if (foundUser == null) {
            return new ResponseEntity<>("Unauthorized access", HttpStatus.UNAUTHORIZED);
        } else {
            return foundUser;

        }

    }
}
