package com.analyser.resumeanalyzer.controller;
import com.analyser.resumeanalyzer.service.ResumeJDPairService;
import com.analyser.resumeanalyzer.entity.ResumeJDPair;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class ResumeJDController {
	  @Autowired
	    private ResumeJDPairService resumeJDService;
        //Saving Resume JD pair with associated User ID
	    @PostMapping
	    public ResponseEntity<String> uploadResumeAndJD(
	            @RequestParam("resume") MultipartFile resume,
	            @RequestParam("jobDescription") String jobDescription,
	            @RequestParam("userId") Long userId) throws IOException {
	        resumeJDService.saveResumeJDPair(userId, resume, jobDescription);
	        return ResponseEntity.ok("Resume and JD uploaded successfully.");
      }
	    
	    // GET: Fetch all ResumeJDPair for a specific user
	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<ResumeJDPair>> getAllResumeJDPairsByUser(@PathVariable Long userId) {
	        List<ResumeJDPair> pairs = resumeJDService.getResumeJDPairsByUserId(userId);
	        return ResponseEntity.ok(pairs);
	    }

	    // GET: Fetch a specific ResumeJDPair by pairId
	    @GetMapping("/pair/{pairId}")
	    public ResponseEntity<ResumeJDPair> getResumeJDPairById(@PathVariable Long pairId) {
	        ResumeJDPair pair = resumeJDService.getResumeJDPairByPairId(pairId);
	        return ResponseEntity.ok(pair);
	    }  
	       	    
	    
}