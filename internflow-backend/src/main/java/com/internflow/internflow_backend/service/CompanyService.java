package com.internflow.internflow_backend.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.dto.CompanyCreateRequest;
import com.internflow.internflow_backend.entity.Company;
import com.internflow.internflow_backend.entity.User;
import com.internflow.internflow_backend.repository.CompanyRepository;
import com.internflow.internflow_backend.repository.UserRepository;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    public CompanyService(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    public Company createCompany(CompanyCreateRequest request, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));

        Company company = new Company();
        company.setId(user.getId());
        company.setEmail(user.getEmail());
        company.setPassword(user.getPassword());
        company.setRole(user.getRole());

        company.setCompanyName(request.getCompanyName());
        company.setIndustry(request.getIndustry());
        company.setAddress(request.getAddress());
        company.setWebsite(request.getWebsite());
        company.setLogoUrl(request.getLogoUrl());
        company.setHrContactName(request.getHrContactName());
        company.setHrContactTitle(request.getHrContactTitle());

        return companyRepository.save(company);
    }
}
