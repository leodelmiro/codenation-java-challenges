package com.challenge.entity.listeners;

import com.challenge.entity.Candidate;

import javax.persistence.*;

public class CandidateListener {

    @PrePersist
    void onPrePersist(Candidate candidate) {
        System.out.println("CandidateListener.onPrePersist(): " + candidate);
    }

    @PostPersist
    void onPostPersist(Candidate candidate) {
        System.out.println("CandidateListener.onPostPersist(): " + candidate);
    }

    @PostLoad
    void onPostLoad(Candidate candidate) {
        System.out.println("CandidateListener.onPostLoad(): " + candidate);
    }

    @PreUpdate
    void onPreUpdate(Candidate candidate) {
        System.out.println("CandidateListener.onPreUpdate(): " + candidate);
    }

    @PostUpdate
    void onPostUpdate(Candidate candidate) {
        System.out.println("CandidateListener.onPostUpdate(): " + candidate);
    }

    @PreRemove
    void onPreRemove(Candidate candidate) {
        System.out.println("CandidateListener.onPreRemove(): " + candidate);
    }

    @PostRemove
    void onPostRemove(Candidate candidate) {
        System.out.println("CandidateListener.onPostRemove(): " + candidate);
    }
}