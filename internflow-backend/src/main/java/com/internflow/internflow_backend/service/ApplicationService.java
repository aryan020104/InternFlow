package com.internflow.internflow_backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.dto.ApplicationCreateRequest;
import com.internflow.internflow_backend.dto.ApplicationResponse;
import com.internflow.internflow_backend.dto.ApplicationUpdateRequest;
import com.internflow.internflow_backend.entity.Application;
import com.internflow.internflow_backend.entity.Internship;
import com.internflow.internflow_backend.entity.Student;
import com.internflow.internflow_backend.repository.ApplicationRepository;
import com.internflow.internflow_backend.repository.InternshipRepository;
import com.internflow.internflow_backend.repository.StudentRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final InternshipRepository internshipRepository;
    private final StudentRepository studentRepository;

    public ApplicationService(
            ApplicationRepository applicationRepository,
            InternshipRepository internshipRepository,
            StudentRepository studentRepository) {

        this.applicationRepository = applicationRepository;
        this.internshipRepository = internshipRepository;
        this.studentRepository = studentRepository;
    }

    public ApplicationResponse createApplication(
            ApplicationCreateRequest request,
            UUID studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException(
                        "Student not found: " + studentId));

        Internship internship = internshipRepository.findById(request.getInternshipId())
                .orElseThrow(() -> new RuntimeException(
                        "Internship not found: " + request.getInternshipId()));

        Application application = new Application();

        application.setStudent(student);
        application.setInternship(internship);

        Application savedApplication =
                applicationRepository.save(application);

        return toResponse(savedApplication);
    }

    public List<ApplicationResponse> getMyApplications(UUID studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException(
                        "Student not found: " + studentId));

        return applicationRepository.findAll()
                .stream()
                .filter(application ->
                        application.getStudent()
                                .getId()
                                .equals(student.getId()))
                .map(this::toResponse)
                .toList();
    }

    public ApplicationResponse updateMyApplication(
            UUID studentId,
            UUID applicationId,
            ApplicationUpdateRequest request) {

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException(
                        "Application not found: " + applicationId));

        if (!application.getStudent().getId().equals(studentId)) {
            throw new RuntimeException(
                    "You are not allowed to modify this application");
        }

        application.setStatus(request.getStatus());

        Application updatedApplication =
                applicationRepository.save(application);

        return toResponse(updatedApplication);
    }

    private ApplicationResponse toResponse(Application application) {

        ApplicationResponse response = new ApplicationResponse();

        response.setId(application.getId());
        response.setInternshipId(
                application.getInternship().getId());
        response.setStatus(application.getStatus());
        response.setAppliedAt(application.getAppliedAt());

        return response;
    }
}