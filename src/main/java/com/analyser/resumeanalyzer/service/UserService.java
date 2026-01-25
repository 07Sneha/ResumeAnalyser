package com.analyser.resumeanalyzer.service;

import com.analyser.resumeanalyzer.entity.User;
import com.analyser.resumeanalyzer.repository.UserRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/*import java.util.Map;
import java.util.HashMap;
import java.util.Optional;*/

@Service
public class UserService {

	
	   @Autowired
	    private UserRepository userRepository;
	   
	   @Autowired
	    private PasswordEncoder passwordEncoder;
	   
	 // POST: Save new user
    public User saveUser(String name, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("User already exists with email: " + email);
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password); // Consider encoding if using security

        return userRepository.save(user);
    }
	
    public boolean updatePassword(Long userId, String newPassword) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(newPassword); // Ideally, hash the password
            userRepository.save(user);
            return true;
        }
        return false;
    }
    
    public boolean authenticateUser(String email, String rawPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Check if password matches
            return passwordEncoder.matches(rawPassword, user.getPassword());
        }
        return false;
    }
}
