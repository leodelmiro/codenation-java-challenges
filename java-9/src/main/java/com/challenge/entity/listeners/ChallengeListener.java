package com.challenge.entity.listeners;

import com.challenge.entity.Challenge;

import javax.persistence.*;

public class ChallengeListener {

    @PrePersist
    void onPrePersist(Challenge challenge) {
        System.out.println("ChallengeListener.onPrePersist(): " + challenge);
    }

    @PostPersist
    void onPostPersist(Challenge challenge) {
        System.out.println("ChallengeListener.onPostPersist(): " + challenge);
    }

    @PostLoad
    void onPostLoad(Challenge challenge) {
        System.out.println("ChallengeListener.onPostLoad(): " + challenge);
    }

    @PreUpdate
    void onPreUpdate(Challenge challenge) {
        System.out.println("ChallengeListener.onPreUpdate(): " + challenge);
    }

    @PostUpdate
    void onPostUpdate(Challenge challenge) {
        System.out.println("ChallengeListener.onPostUpdate(): " + challenge);
    }

    @PreRemove
    void onPreRemove(Challenge challenge) {
        System.out.println("ChallengeListener.onPreRemove(): " + challenge);
    }

    @PostRemove
    void onPostRemove(Challenge challenge) {
        System.out.println("ChallengeListener.onPostRemove(): " + challenge);
    }
}