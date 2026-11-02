package com.internflow.internflow_backend.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.internflow.internflow_backend.entity.ApplicationStatus;

public class ApplicationStatusHistoryResponse {

    private UUID id;
    private ApplicationStatus status;
    private LocalDateTime changedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
}