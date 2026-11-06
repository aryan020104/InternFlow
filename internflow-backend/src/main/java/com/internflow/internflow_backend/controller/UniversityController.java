package com.internflow.internflow_backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.internflow.internflow_backend.entity.University;
import com.internflow.internflow_backend.service.UniversityService;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping
    public List<University> getAllUniversities() {
        return universityService.getAllUniversities();
    }

    @GetMapping("/{id}")
    public University getUniversityById(@PathVariable UUID id) {
        return universityService.getUniversityById(id);
    }

    @PostMapping
    public University createUniversity(@RequestBody University university) {
        return universityService.createUniversity(university);
    }
}