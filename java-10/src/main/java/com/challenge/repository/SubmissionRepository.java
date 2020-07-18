package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    @Query("SELECT COALESCE(MAX(s.score), 0) FROM Submission s WHERE s.id.challenge.id = ?1")
    BigDecimal findHigherScoreByChallengeId(Long challengeId);

    @Query("FROM Submission s INNER JOIN Acceleration a ON a.challenge.id = s.id.challenge.id" +
            " WHERE s.id.challenge.id = ?1 AND a.id = ?2")
    List<Submission> findAllByIdChallengeIdAndIdAccelerationId(Long challengeId, Long accelerationId);
}
