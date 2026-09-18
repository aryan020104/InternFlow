package com.internflow.internflow_backend.controller;

import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internflow.internflow_backend.dto.CompanyCreateRequest;
import com.internflow.internflow_backend.entity.Company;
import com.internflow.internflow_backend.service.CompanyService;

@RestController
@RequestMapping("api/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PreAuthorize("hasRole('COMPANY')")
    @PostMapping
    public Company createCompany(@RequestBody CompanyCreateRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UUID userId = UUID.fromString(authentication.getName());

        return companyService.createCompany(request, userId);
    }

}