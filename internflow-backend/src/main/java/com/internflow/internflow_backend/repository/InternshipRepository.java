package com.internflow.internflow_backend.repository;



import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internflow.internflow_backend.entity.Internship;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, UUID> {
}