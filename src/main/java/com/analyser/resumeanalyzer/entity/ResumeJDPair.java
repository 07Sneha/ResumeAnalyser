package com.analyser.resumeanalyzer.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "resume_jd_pair")  
public class ResumeJDPair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pair_id")
    private Long pairId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    private User user;

    @Column(name = "resume_file_name", nullable = false)
    private String resumeFileName;  

    @Lob
    @Column(name = "resume_file", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] resumeBlob;  

    @Column(name = "jd_description", nullable = false, columnDefinition = "TEXT")
    private String jobDescription;  

    @Column(name = "uploaded_at", nullable = false, updatable = false)
    private LocalDateTime uploadTime = LocalDateTime.now();  

    // Constructors
    public ResumeJDPair() {}

    public ResumeJDPair(User user, String resumeFileName, byte[] resumeBlob, String jobDescription) {
        this.user = user;
        this.resumeFileName = resumeFileName;
        this.resumeBlob = resumeBlob;
        this.jobDescription = jobDescription;
    }

    // Getters and Setters

    public Long getPairId() {
        return pairId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    public byte[] getResumeBlob() {
        return resumeBlob;
    }

    public void setResumeBlob(byte[] resumeBlob) {
        this.resumeBlob = resumeBlob;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }
}

