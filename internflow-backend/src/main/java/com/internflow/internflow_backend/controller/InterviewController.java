package com.internflow.internflow_backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.internflow.internflow_backend.entity.Interview;
import com.internflow.internflow_backend.service.InterviewService;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviewService.getAllInterviews();
    }

    @GetMapping("/{id}")
    public Interview getInterviewById(@PathVariable UUID id) {
        return interviewService.getInterviewById(id);
    }

    @PostMapping
    public Interview createInterview(@RequestBody Interview interview) {
        return interviewService.createInterview(interview);
    }

    @PutMapping("/{id}")
    public Interview updateInterview(
            @PathVariable UUID id,
            @RequestBody Interview interview) {
        return interviewService.updateInterview(id, interview);
    }

    @DeleteMapping("/{id}")
    public void deleteInterview(@PathVariable UUID id) {
        interviewService.deleteInterview(id);
    }
}