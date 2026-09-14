package com.internflow.internflow_backend.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.UUID;

import com.internflow.internflow_backend.entity.InternshipDuration;
import com.internflow.internflow_backend.entity.InternshipField;
import com.internflow.internflow_backend.entity.InternshipStatus;

public class InternshipResponse {
    private UUID id;
    private String title;
    private InternshipField field;
    private String location;
    private InternshipDuration duration;
    private String compensation;
    private String description;
    private InternshipStatus status;
    private LocalDateTime postedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public InternshipField getField() {
        return field;
    }

    public void setField(InternshipField field) {
        this.field = field;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public InternshipDuration getDuration() {
        return duration;
    }

    public void setDuration(InternshipDuration duration) {
        this.duration = duration;
    }

    public String getCompensation() {
        return compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InternshipStatus getStatus() {
        return status;
    }

    public void setStatus(InternshipStatus status) {
        this.status = status;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

}
