package com.internflow.internflow_backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internflow.internflow_backend.entity.Interview;

public interface InterviewRepository extends JpaRepository<Interview, UUID> {
}