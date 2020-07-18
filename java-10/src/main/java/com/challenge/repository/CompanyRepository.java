package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findAllByCandidatesIdUserId(Long userId);

    List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);
}