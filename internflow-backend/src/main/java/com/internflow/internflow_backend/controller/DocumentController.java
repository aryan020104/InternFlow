package com.internflow.internflow_backend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.internflow.internflow_backend.entity.Document;
import com.internflow.internflow_backend.service.DocumentService;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public Document getDocumentById(@PathVariable UUID id) {
        return documentService.getDocumentById(id);
    }

    @GetMapping("/student/{studentId}")
    public List<Document> getDocumentsByStudentId(@PathVariable UUID studentId) {
        return documentService.getDocumentsByStudentId(studentId);
    }

    @GetMapping("/application/{applicationId}")
    public List<Document> getDocumentsByApplicationId(@PathVariable UUID applicationId) {
        return documentService.getDocumentsByApplicationId(applicationId);
    }

    @PostMapping
    public Document createDocument(@RequestBody Document document) {
        return documentService.createDocument(document);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable UUID id) {
        documentService.deleteDocument(id);
    }
}