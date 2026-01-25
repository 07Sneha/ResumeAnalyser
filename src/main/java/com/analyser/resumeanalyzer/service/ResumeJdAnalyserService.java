package com.analyser.resumeanalyzer.service;

import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.analyser.resumeanalyzer.dto.ResumeAnalysisResultDTO;
import com.analyser.resumeanalyzer.service.analysersupport.SkillLibrary;
import com.analyser.resumeanalyzer.service.analysersupport.TextPreprocessor;

@Service
public class ResumeJdAnalyserService {
	
	public String extractTextFromMultipartFile(MultipartFile file) throws IOException, TikaException {
	    Tika tika = new Tika();
	    return tika.parseToString(file.getInputStream());
	}
	
	public ResumeAnalysisResultDTO  getAnalysisResult(String resumeText, String jdText) {
	    return analyze(resumeText, jdText);
	}

    public static ResumeAnalysisResultDTO  analyze(String resumeText, String jdText) {
        // Preprocess both texts
        Set<String> resumeWords = TextPreprocessor.preprocess(resumeText);
        Set<String> jdWords = TextPreprocessor.preprocess(jdText);

        List<String> masterSkills = SkillLibrary.getMasterSkillList();

        // Extract skills present in JD from master skill list
        Set<String> jdSkills = masterSkills.stream()
                .filter(jdWords::contains)
                .collect(Collectors.toSet());

        // Match skills between resume and JD
        Set<String> matchedSkills = jdSkills.stream()
                .filter(resumeWords::contains)
                .collect(Collectors.toSet());

        // Missing skills (suggestions)
        Set<String> missingSkills = new HashSet<>(jdSkills);
        missingSkills.removeAll(matchedSkills);

        // Compute score
        int matchedCount = matchedSkills.size();
        int totalCount = jdSkills.size();
        double matchScore = totalCount == 0 ? 0.0 : ((double) matchedCount / totalCount) * 100;

        // Generate summary
        String summary = String.format(
            "Your resume matches %d out of %d key skills (%.2f%%) required by the job description. Skills matched: %s",
            matchedCount,
            totalCount,
            matchScore,
            matchedSkills.isEmpty() ? "None" : String.join(", ", matchedSkills)
        );

        return new ResumeAnalysisResultDTO (
                matchScore,
                matchedCount,
                new ArrayList<>(matchedSkills),
                summary,
                new ArrayList<>(missingSkills)
        );
    }
}
