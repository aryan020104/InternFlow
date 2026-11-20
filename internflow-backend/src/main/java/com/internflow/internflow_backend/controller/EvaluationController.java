package com.internflow.internflow_backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.internflow.internflow_backend.entity.Evaluation;
import com.internflow.internflow_backend.service.EvaluationService;

@RestController
@RequestMapping("/api/evaluations")
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @GetMapping
    public List<Evaluation> getAllEvaluations() {
        return evaluationService.getAllEvaluations();
    }

    @GetMapping("/{id}")
    public Evaluation getEvaluationById(@PathVariable UUID id) {
        return evaluationService.getEvaluationById(id);
    }

    @PostMapping
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationService.createEvaluation(evaluation);
    }

    @PutMapping("/{id}")
    public Evaluation updateEvaluation(
            @PathVariable UUID id,
            @RequestBody Evaluation evaluation) {
        return evaluationService.updateEvaluation(id, evaluation);
    }

    @DeleteMapping("/{id}")
    public void deleteEvaluation(@PathVariable UUID id) {
        evaluationService.deleteEvaluation(id);
    }
}