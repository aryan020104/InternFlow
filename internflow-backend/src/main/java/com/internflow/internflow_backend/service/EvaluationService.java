package com.internflow.internflow_backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.entity.Evaluation;
import com.internflow.internflow_backend.repository.EvaluationRepository;

@Service
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    public Evaluation getEvaluationById(UUID id) {
        return evaluationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluation not found"));
    }

    public Evaluation createEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public Evaluation updateEvaluation(UUID id, Evaluation updatedEvaluation) {
        Evaluation existingEvaluation = getEvaluationById(id);

        existingEvaluation.setTechnicalScore(updatedEvaluation.getTechnicalScore());
        existingEvaluation.setCommunicationScore(updatedEvaluation.getCommunicationScore());
        existingEvaluation.setCultureFitScore(updatedEvaluation.getCultureFitScore());
        existingEvaluation.setOverallScore(updatedEvaluation.getOverallScore());
        existingEvaluation.setWrittenFeedback(updatedEvaluation.getWrittenFeedback());
        existingEvaluation.setStatus(updatedEvaluation.getStatus());
        existingEvaluation.setSubmittedAt(updatedEvaluation.getSubmittedAt());

        return evaluationRepository.save(existingEvaluation);
    }

    public void deleteEvaluation(UUID id) {
        evaluationRepository.deleteById(id);
    }
}