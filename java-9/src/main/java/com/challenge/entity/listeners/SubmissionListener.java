package com.challenge.entity.listeners;

import com.challenge.entity.Submission;

import javax.persistence.*;

public class SubmissionListener {

    @PrePersist
    void onPrePersist(Submission submission) {
        System.out.println("SubmissionListener.onPrePersist(): " + submission);
    }

    @PostPersist
    void onPostPersist(Submission submission) {
        System.out.println("SubmissionListener.onPostPersist(): " + submission);
    }

    @PostLoad
    void onPostLoad(Submission submission) {
        System.out.println("SubmissionListener.onPostLoad(): " + submission);
    }

    @PreUpdate
    void onPreUpdate(Submission submission) {
        System.out.println("SubmissionListener.onPreUpdate(): " + submission);
    }

    @PostUpdate
    void onPostUpdate(Submission submission) {
        System.out.println("SubmissionListener.onPostUpdate(): " + submission);
    }

    @PreRemove
    void onPreRemove(Submission submission) {
        System.out.println("SubmissionListener.onPreRemove(): " + submission);
    }

    @PostRemove
    void onPostRemove(Submission submission) {
        System.out.println("SubmissionListener.onPostRemove(): " + submission);
    }
}