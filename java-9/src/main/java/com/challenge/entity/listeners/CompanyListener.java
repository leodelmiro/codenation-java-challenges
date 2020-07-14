package com.challenge.entity.listeners;

import com.challenge.entity.Company;

import javax.persistence.*;

public class CompanyListener {

    @PrePersist
    void onPrePersist(Company company) {
        System.out.println("CompanyListener.onPrePersist(): " + company);
    }

    @PostPersist
    void onPostPersist(Company company) {
        System.out.println("CompanyListener.onPostPersist(): " + company);
    }

    @PostLoad
    void onPostLoad(Company company) {
        System.out.println("CompanyListener.onPostLoad(): " + company);
    }

    @PreUpdate
    void onPreUpdate(Company company) {
        System.out.println("CompanyListener.onPreUpdate(): " + company);
    }

    @PostUpdate
    void onPostUpdate(Company company) {
        System.out.println("CompanyListener.onPostUpdate(): " + company);
    }

    @PreRemove
    void onPreRemove(Company company) {
        System.out.println("CompanyListener.onPreRemove(): " + company);
    }

    @PostRemove
    void onPostRemove(Company company) {
        System.out.println("CompanyListener.onPostRemove(): " + company);
    }
}