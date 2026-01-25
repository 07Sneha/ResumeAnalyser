package com.analyser.resumeanalyzer.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.analyser.resumeanalyzer.dto.ResumeAnalysisResultDTO;
import com.analyser.resumeanalyzer.entity.Report;
import com.analyser.resumeanalyzer.repository.ReportRepository;

@Service
public class ReportService {
	 @Autowired
	    private ReportRepository reportRepository;

	    public Report saveAnalysisResult(Long pairId, ResumeAnalysisResultDTO resultDTO) {
	        Report report = new Report(
	            pairId,
	            BigDecimal.valueOf(resultDTO.getMatchScore()),
	            resultDTO.getKeywordsMatchedCount(),
	            String.join(", ", resultDTO.getKeywordsMatchedList()),
	            resultDTO.getSummary()
	        );

	        return reportRepository.save(report);
  }
	    
	    public Report getReportByPairId(Long pairId) {
	        Report report = reportRepository.findByPairId(pairId);
	        return report;
	    }
}