package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {
    List<Acceleration> findAllByName(String name);

    List<Acceleration> findAllByCandidatesIdCompanyId(Long id);
}
