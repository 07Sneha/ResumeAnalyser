package com.analyser.resumeanalyzer.controller;


import com.analyser.resumeanalyzer.entity.Report;
import com.analyser.resumeanalyzer.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/reports")
public class ReportController {
	
	    @Autowired
	    private ReportService reportService;

	    /**
	     * Generate report for a given user ID.
	     * This will match the latest uploaded resume and JD.
	     */

	    @GetMapping("/{pairId}")
	    public ResponseEntity<Report> getReportByPairId(@PathVariable Long pairId) {
	        Report report = reportService.getReportByPairId(pairId);
	        if (report != null) {
	            return ResponseEntity.ok(report);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }        
}

