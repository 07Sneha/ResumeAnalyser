package com.analyser.resumeanalyzer.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OtpService {

    private static final long EXPIRE_TIME = 1; // in hours

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void saveOtp(String email, String otp) {
        redisTemplate.opsForValue().set(email, otp, EXPIRE_TIME, TimeUnit.HOURS);
    }

    public boolean validateOtp(String email, String otp) {
        String storedOtp = redisTemplate.opsForValue().get(email);
        return otp.equals(storedOtp);
    }

    public void deleteOtp(String email) {
        redisTemplate.delete(email);
    }
}


