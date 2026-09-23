package com.internflow.internflow_backend.controller;

import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internflow.internflow_backend.dto.StudentCreateRequest;
import com.internflow.internflow_backend.dto.StudentResponse;
import com.internflow.internflow_backend.dto.StudentUpdateRequest;
import com.internflow.internflow_backend.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping
    public StudentResponse createStudent(
            @RequestBody StudentCreateRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UUID userId = UUID.fromString(authentication.getName());

        studentService.createStudent(request, userId);

        return studentService.getMyStudent(userId);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/me")
    public StudentResponse getMyStudent() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UUID userId = UUID.fromString(authentication.getName());

        return studentService.getMyStudent(userId);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping("/me")
    public StudentResponse updateMyStudent(
            @RequestBody StudentUpdateRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UUID userId = UUID.fromString(authentication.getName());

        return studentService.updateMyStudent(userId, request);
    }
}