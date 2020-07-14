package com.challenge.entity.listeners;

import com.challenge.entity.Acceleration;

import javax.persistence.*;

public class AccelerationListener {

    @PrePersist
    void onPrePersist(Acceleration acceleration) {
        System.out.println("AccelerationListener.onPrePersist(): " + acceleration);
    }

    @PostPersist
    void onPostPersist(Acceleration acceleration) {
        System.out.println("AccelerationListener.onPostPersist(): " + acceleration);
    }

    @PostLoad
    void onPostLoad(Acceleration acceleration) {
        System.out.println("AccelerationListener.onPostLoad(): " + acceleration);
    }

    @PreUpdate
    void onPreUpdate(Acceleration acceleration) {
        System.out.println("AccelerationListener.onPreUpdate(): " + acceleration);
    }

    @PostUpdate
    void onPostUpdate(Acceleration acceleration) {
        System.out.println("AccelerationListener.onPostUpdate(): " + acceleration);
    }

    @PreRemove
    void onPreRemove(Acceleration acceleration) {
        System.out.println("AccelerationListener.onPreRemove(): " + acceleration);
    }

    @PostRemove
    void onPostRemove(Acceleration acceleration) {
        System.out.println("AccelerationListener.onPostRemove(): " + acceleration);
    }
}