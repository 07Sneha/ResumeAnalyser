/*package com.analyser.resumeanalyzer.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.analyser.resumeanalyzer.entity.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
	    Report findByResumeJDPairPairId(Long pairId);
	    List<Report> findByResumeJDPairUserUserId(Long userId);
	}
*/
package com.analyser.resumeanalyzer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.analyser.resumeanalyzer.entity.Report;
 
public interface ReportRepository extends JpaRepository<Report, Integer> {
	
	Report findByPairId(Long pairId);
}