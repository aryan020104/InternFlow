package com.internflow.internflow_backend.dto;

import java.util.UUID;

public class ApplicationCreateRequest {

    private UUID internshipId;

    public UUID getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(UUID internshipId) {
        this.internshipId = internshipId;
    }
}