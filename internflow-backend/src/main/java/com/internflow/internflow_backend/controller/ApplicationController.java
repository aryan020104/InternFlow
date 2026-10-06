
package com.internflow.internflow_backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.internflow.internflow_backend.dto.ApplicationCreateRequest;
import com.internflow.internflow_backend.dto.ApplicationResponse;
import com.internflow.internflow_backend.dto.ApplicationUpdateRequest;
import com.internflow.internflow_backend.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping
    public ApplicationResponse createApplication(
            @RequestBody ApplicationCreateRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UUID studentId = UUID.fromString(authentication.getName());

        return applicationService.createApplication(request, studentId);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/me")
    public List<ApplicationResponse> getMyApplications() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UUID studentId = UUID.fromString(authentication.getName());

        return applicationService.getMyApplications(studentId);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PutMapping("/{applicationId}")
    public ApplicationResponse updateMyApplication(
            @PathVariable UUID applicationId,
            @RequestBody ApplicationUpdateRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UUID studentId = UUID.fromString(authentication.getName());

        return applicationService.updateMyApplication(
                studentId,
                applicationId,
                request);
    }
}
