package com.analyser.resumeanalyzer.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResumeAnalysisResultDTO {
	private double matchScore;
    private int keywordsMatchedCount;
    private List<String> keywordsMatchedList;
    private String summary;
    private List<String> MissingSkills;
    

	public ResumeAnalysisResultDTO(double matchScore, int keywordsMatchedCount, List<String> keywordsMatchedList,
			String summary, List<String> MissingSkills) {
		super();
		this.matchScore = matchScore;
		this.keywordsMatchedCount = keywordsMatchedCount;
		this.keywordsMatchedList = keywordsMatchedList;
		this.summary = summary;
		this.MissingSkills=MissingSkills;
	}
	
	public double getMatchScore() {
		return matchScore;
	}
	public void setMatchScore(double matchScore) {
		this.matchScore = matchScore;
	}
	public int getKeywordsMatchedCount() {
		return keywordsMatchedCount;
	}
	public void setKeywordsMatchedCount(int keywordsMatchedCount) {
		this.keywordsMatchedCount = keywordsMatchedCount;
	}
	public List<String> getKeywordsMatchedList() {
		return keywordsMatchedList;
	}
	public void setKeywordsMatchedList(List<String> keywordsMatchedList) {
		this.keywordsMatchedList = keywordsMatchedList;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public List<String> getMissingSkills() {
		return MissingSkills;
	}

	public void setMissingSkills(List<String> missingSkills) {
		MissingSkills = missingSkills;
	}
}
