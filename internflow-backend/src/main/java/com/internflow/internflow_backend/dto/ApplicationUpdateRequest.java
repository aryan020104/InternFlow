package com.internflow.internflow_backend.dto;

import com.internflow.internflow_backend.entity.ApplicationStatus;

public class ApplicationUpdateRequest {
    private ApplicationStatus status;

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}
