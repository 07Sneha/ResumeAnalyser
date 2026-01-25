package com.analyser.resumeanalyzer.service;

import com.analyser.resumeanalyzer.entity.ResumeJDPair;
import com.analyser.resumeanalyzer.entity.User;
import com.analyser.resumeanalyzer.repository.ResumeJDPairRepository;
import com.analyser.resumeanalyzer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
@Service
public class ResumeJDPairService {

    @Autowired
    private ResumeJDPairRepository resumeJDPairRepository;

    @Autowired
    private UserRepository userRepository;

   /* @Autowired
    private ReportService reportService; // You must implement this separately.*/
    
    // POST: Save resume-JD pair
    public ResumeJDPair saveResumeJDPair(Long userId, MultipartFile resumeFile, String jobDescription) throws IOException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        User user = optionalUser.get();
        byte[] resumeBytes = resumeFile.getBytes();
        String resumeName= resumeFile.getOriginalFilename();
        ResumeJDPair pair = new ResumeJDPair(user, resumeName ,resumeBytes, jobDescription);
        return resumeJDPairRepository.save(pair);
    }
    
   
    public List<ResumeJDPair> getResumeJDPairsByUserId(Long userId) {
        return resumeJDPairRepository.findByUserId(userId);
    }

 
    public ResumeJDPair getResumeJDPairByPairId(Long pairId) {
        return resumeJDPairRepository.findById(pairId)
                .orElseThrow(() -> new IllegalArgumentException("Pair not found with ID: " + pairId));
    }
    
}