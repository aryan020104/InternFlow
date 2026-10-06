package com.internflow.internflow_backend.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.internflow.internflow_backend.entity.ApplicationStatus;

public class ApplicationResponse {
    private UUID id;
    private UUID internshipId;
    private ApplicationStatus status;
    private LocalDateTime appliedAt;
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getInternshipId() {
        return internshipId;
    }
    public void setInternshipId(UUID internshipId) {
        this.internshipId = internshipId;
    }
    public ApplicationStatus getStatus() {
        return status;
    }
    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }
    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }


   
}
