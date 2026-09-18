package com.internflow.internflow_backend.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internflow.internflow_backend.entity.Company;


public interface  CompanyRepository extends JpaRepository<Company, UUID> {
    
}
