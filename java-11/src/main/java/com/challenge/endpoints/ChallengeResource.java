package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/challenge")
public class ChallengeResource {
    @Autowired
    private ChallengeServiceInterface service;

    @GetMapping
    public ResponseEntity<List<Challenge>> findByAccelerationIdAndUserId(@RequestParam Long accelerationId, @RequestParam Long userId) {
        List<Challenge> challenges = service.findByAccelerationIdAndUserId(accelerationId, userId);
        return ResponseEntity.ok().body(challenges);
    }
}