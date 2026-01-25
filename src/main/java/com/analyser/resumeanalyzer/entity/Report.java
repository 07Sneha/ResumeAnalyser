package com.analyser.resumeanalyzer.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "pair_id", nullable = false)
    private Long pairId;

    @Column(name = "match_score", precision = 5, scale = 2)
    private BigDecimal matchScore;

    @Column(name = "keywords_matched_count")
    private Integer keywordsMatchedCount;

    @Column(name = "keywords_matched_list", columnDefinition = "TEXT")
    private String keywordsMatchedList;

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "generated_at", nullable = false, updatable = false)
    private LocalDateTime generatedAt = LocalDateTime.now();  
    
    // Constructors
    public Report() {}
    
    public Report(Long pairId, BigDecimal matchScore, Integer keywordsMatchedCount, String keywordsMatchedList, String summary) {
        this.pairId = pairId;
        this.matchScore = matchScore;
        this.keywordsMatchedCount = keywordsMatchedCount;
        this.keywordsMatchedList = keywordsMatchedList;
        this.summary = summary;
    }


    // Getters and Setters

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Long getPairId() {
        return pairId;
    }

    public void setPairId(Long pairId) {
        this.pairId = pairId;
    }

    public BigDecimal getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(BigDecimal matchScore) {
        this.matchScore = matchScore;
    }

    public Integer getKeywordsMatchedCount() {
        return keywordsMatchedCount;
    }

    public void setKeywordsMatchedCount(Integer keywordsMatchedCount) {
        this.keywordsMatchedCount = keywordsMatchedCount;
    }

    public String getKeywordsMatchedList() {
        return keywordsMatchedList;
    }

    public void setKeywordsMatchedList(String keywordsMatchedList) {
        this.keywordsMatchedList = keywordsMatchedList;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
}

