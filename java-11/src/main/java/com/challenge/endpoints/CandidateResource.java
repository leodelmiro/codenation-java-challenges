package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.endpoints.exceptions.ResourceNotFoundException;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateResource {
    @Autowired
    private CandidateServiceInterface service;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping(value = "/{userId}/{accelerationId}/{companyId}")
    public ResponseEntity<CandidateDTO> findById(@PathVariable Long userId, @PathVariable Long accelerationId, @PathVariable Long companyId) {
        Optional<Candidate> optionalCandidate = service.findById(userId, companyId, accelerationId);
        return optionalCandidate.map(candidate -> ResponseEntity.ok().body(candidateMapper.map(candidate))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> findByCompanyId(@RequestParam(required = false) Long companyId, @RequestParam(required = false) Long accelerationId) {
        if (companyId != null) return ResponseEntity.ok().body(candidateMapper.map(service.findByCompanyId(companyId)));
        if (accelerationId != null) return ResponseEntity.ok().body(candidateMapper.map(service.findByAccelerationId(accelerationId)));
        return ResponseEntity.notFound().build();
    }
}
