package com.internflow.internflow_backend.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.dto.StudentCreateRequest;
import com.internflow.internflow_backend.dto.StudentResponse;
import com.internflow.internflow_backend.dto.StudentUpdateRequest;
import com.internflow.internflow_backend.entity.Student;
import com.internflow.internflow_backend.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(StudentCreateRequest request, UUID userId) {

        Student student = studentRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Student not found: " + userId));

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setUniversityId(request.getUniversityId());
        student.setFieldOfStudy(request.getFieldOfStudy());
        student.setPhone(request.getPhone());
        student.setProfilePhotoUrl(request.getProfilePhotoUrl());

        return studentRepository.save(student);
    }

    public StudentResponse getMyStudent(UUID userId) {

        Student student = studentRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Student not found: " + userId));

        StudentResponse response = new StudentResponse();

        response.setId(student.getId());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setUniversityId(student.getUniversityId());
        response.setFieldOfStudy(student.getFieldOfStudy());
        response.setPhone(student.getPhone());
        response.setProfilePhotoUrl(student.getProfilePhotoUrl());

        return response;
    }

    public StudentResponse updateMyStudent(
            UUID userId,
            StudentUpdateRequest request) {

        Student student = studentRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException(
                        "Student not found: " + userId));

        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setUniversityId(request.getUniversityId());
        student.setFieldOfStudy(request.getFieldOfStudy());
        student.setPhone(request.getPhone());
        student.setProfilePhotoUrl(request.getProfilePhotoUrl());

        Student updatedStudent = studentRepository.save(student);

        StudentResponse response = new StudentResponse();

        response.setId(updatedStudent.getId());
        response.setFirstName(updatedStudent.getFirstName());
        response.setLastName(updatedStudent.getLastName());
        response.setUniversityId(updatedStudent.getUniversityId());
        response.setFieldOfStudy(updatedStudent.getFieldOfStudy());
        response.setPhone(updatedStudent.getPhone());
        response.setProfilePhotoUrl(updatedStudent.getProfilePhotoUrl());

        return response;
    }
}
