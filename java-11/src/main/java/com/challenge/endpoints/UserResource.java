package com.challenge.endpoints;

import com.challenge.endpoints.exceptions.ResourceNotFoundException;
import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private UserServiceInterface service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = service.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findByAccelerationName(@RequestParam(required = false) String accelerationName, @RequestParam(required = false) Long companyId) {
        if (accelerationName != null) return ResponseEntity.ok().body(service.findByAccelerationName(accelerationName));
        if (companyId != null) return ResponseEntity.ok().body(service.findByCompanyId(companyId));
        return ResponseEntity.notFound().build();
    }
}
