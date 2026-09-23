package com.internflow.internflow_backend.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.dto.CompanyCreateRequest;
import com.internflow.internflow_backend.dto.CompanyResponse;
import com.internflow.internflow_backend.dto.CompanyUpdateRequest;
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

    public CompanyResponse getMyCompany(UUID userId) {

        Company company = companyRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Company not found: " + userId));

        CompanyResponse response = new CompanyResponse();

        response.setId(company.getId());
        response.setCompanyName(company.getCompanyName());
        response.setIndustry(company.getIndustry());
        response.setAddress(company.getAddress());
        response.setWebsite(company.getWebsite());
        response.setLogoUrl(company.getLogoUrl());
        response.setHrContactName(company.getHrContactName());
        response.setHrContactTitle(company.getHrContactTitle());

        return response;
    }

    public CompanyResponse updateMyCompany(
            UUID userId,
            CompanyUpdateRequest request) {

        Company company = companyRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Company not found: " + userId));

        company.setCompanyName(request.getCompanyName());
        company.setIndustry(request.getIndustry());
        company.setAddress(request.getAddress());
        company.setWebsite(request.getWebsite());
        company.setLogoUrl(request.getLogoUrl());
        company.setHrContactName(request.getHrContactName());
        company.setHrContactTitle(request.getHrContactTitle());

        Company updatedCompany = companyRepository.save(company);

        CompanyResponse response = new CompanyResponse();

        response.setId(updatedCompany.getId());
        response.setCompanyName(updatedCompany.getCompanyName());
        response.setIndustry(updatedCompany.getIndustry());
        response.setAddress(updatedCompany.getAddress());
        response.setWebsite(updatedCompany.getWebsite());
        response.setLogoUrl(updatedCompany.getLogoUrl());
        response.setHrContactName(updatedCompany.getHrContactName());
        response.setHrContactTitle(updatedCompany.getHrContactTitle());

        return response;
    }
}
