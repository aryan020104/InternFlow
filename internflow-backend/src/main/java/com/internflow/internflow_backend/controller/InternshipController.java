package com.internflow.internflow_backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internflow.internflow_backend.dto.InternshipCreateRequest;
import com.internflow.internflow_backend.dto.InternshipResponse;
import com.internflow.internflow_backend.dto.InternshipUpdateRequest;
import com.internflow.internflow_backend.entity.Internship;
import com.internflow.internflow_backend.service.InternshipService;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/internships")
public class InternshipController {

    private final InternshipService internshipService;

    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @GetMapping
    public List<InternshipResponse> getAllInternships() {
        return internshipService.getAllInternships();
    }

    @GetMapping("/{id}")
    public InternshipResponse getInternshipById(@PathVariable UUID id) {
        return internshipService.getInternshipById(id);
    }

    @PreAuthorize("hasRole('COMPANY')")
    @PostMapping
    public Internship createInternship(
            @RequestBody InternshipCreateRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UUID userId = UUID.fromString(authentication.getName());

        return internshipService.createInternship(request, userId);
    }

    @PreAuthorize("hasRole('COMPANY')")
    @DeleteMapping("/{id}")
    public void deleteInternship(@PathVariable UUID id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UUID userId = UUID.fromString(authentication.getName());

        internshipService.deleteInternship(id, userId);
    }

    @PreAuthorize("hasRole('COMPANY')")
    @PutMapping("/{id}")
    public InternshipResponse updateInternship(
            @PathVariable UUID id,
            @RequestBody InternshipUpdateRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UUID userId = UUID.fromString(authentication.getName());

        return internshipService.updateInternship(id, request, userId);
    }

}