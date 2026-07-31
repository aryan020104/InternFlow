package com.internflow.internflow_backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "internships")
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String jobTitle;

    private String location;

    private Double salary;

    private String status;

    private LocalDate applicationDate;

    private LocalDate deadline;

    @Column(length = 1000)
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Internship() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public Double getSalary() {
        return salary;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
