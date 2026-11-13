package com.internflow.internflow_backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.entity.Interview;
import com.internflow.internflow_backend.repository.InterviewRepository;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepository;

    public InterviewService(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Interview getInterviewById(UUID id) {
        return interviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));
    }

    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public Interview updateInterview(UUID id, Interview updatedInterview) {

        Interview existingInterview = getInterviewById(id);

        existingInterview.setScheduledAt(updatedInterview.getScheduledAt());
        existingInterview.setDurationMinutes(updatedInterview.getDurationMinutes());
        existingInterview.setStatus(updatedInterview.getStatus());
        existingInterview.setMeetingLink(updatedInterview.getMeetingLink());
        existingInterview.setRescheduleReason(updatedInterview.getRescheduleReason());

        return interviewRepository.save(existingInterview);
    }

    public void deleteInterview(UUID id) {
        interviewRepository.deleteById(id);
    }
}