package com.challenge.endpoints;

import com.challenge.endpoints.exceptions.ResourceNotFoundException;
import com.challenge.entity.Acceleration;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/acceleration")
public class AccelerationResource {

    @Autowired
    private AccelerationServiceInterface service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Acceleration> findById(@PathVariable Long id) {
        Acceleration acceleration = service.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return ResponseEntity.ok().body(acceleration);
    }

    @GetMapping
    public ResponseEntity<List<Acceleration>> findByCompanyId(@RequestParam Long companyId) {
        List<Acceleration> accelerations = service.findByCompanyId(companyId);
        return ResponseEntity.ok().body(accelerations);
    }

}
