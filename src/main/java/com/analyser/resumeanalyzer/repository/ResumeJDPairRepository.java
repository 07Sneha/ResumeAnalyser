package com.analyser.resumeanalyzer.repository;

import com.analyser.resumeanalyzer.entity.ResumeJDPair;
import com.analyser.resumeanalyzer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeJDPairRepository extends JpaRepository<ResumeJDPair, Long> {
    List<ResumeJDPair> findByUser(User user);
    ResumeJDPair findByPairId(Long pairId);
    List<ResumeJDPair> findByUserId(Long userId);
  
}
