package com.internflow.internflow_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "universities")
public class University extends User {

    private String institutionName;

    private String coordinatorName;

    private String coordinatorTitle;

    private String address;

    public University() {
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getCoordinatorName() {
        return coordinatorName;
    }

    public void setCoordinatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    public String getCoordinatorTitle() {
        return coordinatorTitle;
    }

    public void setCoordinatorTitle(String coordinatorTitle) {
        this.coordinatorTitle = coordinatorTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}