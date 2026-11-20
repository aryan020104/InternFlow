package com.internflow.internflow_backend.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(
    name = "evaluations",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "interview_id")
    }
)
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(optional = false)
    @JoinColumn(name = "interview_id", nullable = false, unique = true)
    private Interview interview;

    private Integer technicalScore;

    private Integer communicationScore;

    private Integer cultureFitScore;

    private Integer overallScore;

    @Column(columnDefinition = "TEXT")
    private String writtenFeedback;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EvaluationStatus status;

    private LocalDateTime submittedAt;

    public Evaluation() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Integer getTechnicalScore() {
        return technicalScore;
    }

    public void setTechnicalScore(Integer technicalScore) {
        this.technicalScore = technicalScore;
    }

    public Integer getCommunicationScore() {
        return communicationScore;
    }

    public void setCommunicationScore(Integer communicationScore) {
        this.communicationScore = communicationScore;
    }

    public Integer getCultureFitScore() {
        return cultureFitScore;
    }

    public void setCultureFitScore(Integer cultureFitScore) {
        this.cultureFitScore = cultureFitScore;
    }

    public Integer getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(Integer overallScore) {
        this.overallScore = overallScore;
    }

    public String getWrittenFeedback() {
        return writtenFeedback;
    }

    public void setWrittenFeedback(String writtenFeedback) {
        this.writtenFeedback = writtenFeedback;
    }

    public EvaluationStatus getStatus() {
        return status;
    }

    public void setStatus(EvaluationStatus status) {
        this.status = status;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}