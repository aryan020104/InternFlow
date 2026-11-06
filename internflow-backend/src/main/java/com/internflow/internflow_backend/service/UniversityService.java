package com.internflow.internflow_backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.entity.University;
import com.internflow.internflow_backend.repository.UniversityRepository;

@Service
public class UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    public University getUniversityById(UUID id) {
        return universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found"));
    }

    public University createUniversity(University university) {
        return universityRepository.save(university);
    }
}