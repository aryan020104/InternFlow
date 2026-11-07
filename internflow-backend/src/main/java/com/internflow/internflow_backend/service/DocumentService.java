package com.internflow.internflow_backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.entity.Document;
import com.internflow.internflow_backend.repository.DocumentRepository;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document getDocumentById(UUID id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));
    }

    public List<Document> getDocumentsByStudentId(UUID studentId) {
        return documentRepository.findByStudentId(studentId);
    }

    public List<Document> getDocumentsByApplicationId(UUID applicationId) {
        return documentRepository.findByApplicationId(applicationId);
    }

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    public void deleteDocument(UUID id) {
        documentRepository.deleteById(id);
    }

    public Document updateDocument(UUID id, Document updatedDocument) {

        Document existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found"));

        existingDocument.setType(updatedDocument.getType());
        existingDocument.setFileName(updatedDocument.getFileName());
        existingDocument.setFileUrl(updatedDocument.getFileUrl());
        existingDocument.setFileSizeBytes(updatedDocument.getFileSizeBytes());
        existingDocument.setStatus(updatedDocument.getStatus());
        existingDocument.setUploadedAt(updatedDocument.getUploadedAt());

        return documentRepository.save(existingDocument);
    }
}