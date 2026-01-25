package com.analyser.resumeanalyzer.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.analyser.resumeanalyzer.service.EmailService;
import com.analyser.resumeanalyzer.service.OtpService;

@RestController
@RequestMapping("/api/auth")
public class ForgotPasswordController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestParam String email) {
        String otp = generateOtp(); // Random 6-digit string
        otpService.saveOtp(email, otp);
        emailService.sendOtp(email, otp); // You must implement this service
        return ResponseEntity.ok("OTP sent to your email.");
    }

    @PostMapping("/validate-otp")
    public ResponseEntity<String> validateOtp(@RequestParam String email, @RequestParam String otp) {
        boolean valid = otpService.validateOtp(email, otp);
        if (valid) {
            otpService.deleteOtp(email); // Optional cleanup
            return ResponseEntity.ok("OTP verified. You can reset your password.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired OTP.");
        }
    }

    private String generateOtp() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(999999));
    }
}
//ckrq sibf izko hkst app password
