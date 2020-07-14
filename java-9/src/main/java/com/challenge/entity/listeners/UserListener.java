package com.challenge.entity.listeners;

import com.challenge.entity.User;

import javax.persistence.*;

public class UserListener {

    @PrePersist
    void onPrePersist(User user) {
        System.out.println("UserListener.onPrePersist(): " + user);
    }

    @PostPersist
    void onPostPersist(User user) {
        System.out.println("UserListener.onPostPersist(): " + user);
    }

    @PostLoad
    void onPostLoad(User user) {
        System.out.println("UserListener.onPostLoad(): " + user);
    }

    @PreUpdate
    void onPreUpdate(User user) {
        System.out.println("UserListener.onPreUpdate(): " + user);
    }

    @PostUpdate
    void onPostUpdate(User user) {
        System.out.println("UserListener.onPostUpdate(): " + user);
    }

    @PreRemove
    void onPreRemove(User user) {
        System.out.println("UserListener.onPreRemove(): " + user);
    }

    @PostRemove
    void onPostRemove(User user) {
        System.out.println("UserListener.onPostRemove(): " + user);
    }
}