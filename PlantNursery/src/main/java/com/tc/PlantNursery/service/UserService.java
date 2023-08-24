package com.tc.PlantNursery.service;

import com.tc.PlantNursery.entity.User;
import com.tc.PlantNursery.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    //User register

    public User registerUser(User user) {
        String plainPassword = user.getPassword();
        String hashedPassword = hashPassword(plainPassword); // Hash the password
        user.setPassword(hashedPassword);
        return userRepo.save(user);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); //SHA-256 hashing algorithm
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception
            return null;
        }
    }

    public User validateUserLogin(String email, String password) {
        User foundUser = userRepo.findByEmail(email);
        if (foundUser == null) {
            return null; // User not found
        }

        if (verifyPassword(password, foundUser.getPassword())) {
            return foundUser; // Password matches
        } else {
            return null; // Invalid password
        }
    }

    private boolean verifyPassword(String enteredPassword, String storedHash) {
        String enteredHash = hashPassword(enteredPassword);
        return enteredHash != null && enteredHash.equals(storedHash);
    }


    //Admin part
    public List<User> showStaffUsersForAdmin(){
        return userRepo.findByRole("staff");
    }
}
