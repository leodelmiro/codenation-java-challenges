package com.challenge.endpoints;

import com.challenge.endpoints.exceptions.ResourceNotFoundException;
import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyResource {

    @Autowired
    private CompanyServiceInterface service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Company> findById(@PathVariable Long id) {
        Company company = service.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return ResponseEntity.ok().body(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>> findByAccelerationIdOrCompanyId(@RequestParam(required = false) Long accelerationId, @RequestParam(required = false) Long userId) {
        if (accelerationId != null) return ResponseEntity.ok().body(service.findByAccelerationId(accelerationId));
        if (userId != null) return ResponseEntity.ok().body(service.findByUserId(userId));
        return ResponseEntity.notFound().build();
    }
}
