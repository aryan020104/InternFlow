package com.internflow.internflow_backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internflow.internflow_backend.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, UUID> {

    List<Document> findByStudentId(UUID studentId);

    List<Document> findByApplicationId(UUID applicationId);

}