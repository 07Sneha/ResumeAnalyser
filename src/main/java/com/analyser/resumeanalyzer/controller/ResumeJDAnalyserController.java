package com.analyser.resumeanalyzer.controller;


import com.analyser.resumeanalyzer.dto.ResumeAnalysisResultDTO;
import com.analyser.resumeanalyzer.service.ReportService;
import com.analyser.resumeanalyzer.service.ResumeJdAnalyserService;


import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/validatingResumeJd")
public class ResumeJDAnalyserController {	
	
	@Autowired ResumeJdAnalyserService resumeJdAnalyserService;
	@Autowired
	private ReportService reportService;
	
	@PostMapping("/analyze")
	public ResponseEntity<ResumeAnalysisResultDTO> analyzeResume(
	        @RequestParam("resumeFile") MultipartFile resumeFile,
	        @RequestParam("jdText") String jdText,@RequestParam("pairId") Long pairId) throws IOException, TikaException {
         //To Convert Resume to String from MultipartFile
	    String resumeText = resumeJdAnalyserService.extractTextFromMultipartFile(resumeFile); 
	    //Analyzing Resume and JD with Report as Output
		ResumeAnalysisResultDTO result = resumeJdAnalyserService.getAnalysisResult(resumeText, jdText);
		reportService.saveAnalysisResult(pairId, result);
	    return ResponseEntity.ok(result);
	    
	}
	
}
