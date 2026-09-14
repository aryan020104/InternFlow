package com.internflow.internflow_backend.dto;

import com.internflow.internflow_backend.entity.InternshipDuration;
import com.internflow.internflow_backend.entity.InternshipField;

public class InternshipCreateRequest {

    private String title;
    private InternshipField field;
    private String location;
    private InternshipDuration duration;
    private String compensation;
    private String description;

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

    public String getLocation() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
