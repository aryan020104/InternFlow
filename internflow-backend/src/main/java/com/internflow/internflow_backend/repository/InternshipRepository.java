package com.internflow.internflow_backend.repository;



import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import com.internflow.internflow_backend.entity.Internship;

public interface InternshipRepository extends JpaRepository<Internship, UUID> {
}