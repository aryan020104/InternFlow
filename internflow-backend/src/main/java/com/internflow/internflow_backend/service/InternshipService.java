package com.internflow.internflow_backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.dto.InternshipCreateRequest;
import com.internflow.internflow_backend.entity.Internship;
import com.internflow.internflow_backend.entity.Role;
import com.internflow.internflow_backend.entity.User;
import com.internflow.internflow_backend.repository.InternshipRepository;
import com.internflow.internflow_backend.repository.UserRepository;

@Service
public class InternshipService {

    private final InternshipRepository internshipRepository;
    private final UserRepository userRepository;

    public InternshipService(InternshipRepository internshipRepository, UserRepository userRepository) {
        this.internshipRepository = internshipRepository;
        this.userRepository = userRepository;
    }

    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    public Internship getInternshipById(UUID id) {
        return internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found: " + id));
    }

    public Internship createInternship(InternshipCreateRequest request, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));

        if (user.getRole() != Role.COMPANY) {
            throw new RuntimeException("Only companies can create internships");
        }

        Internship internship = new Internship();

        internship.setUser(user);
        internship.setTitle(request.getTitle());
        internship.setField(request.getField());
        internship.setLocation(request.getLocation());
        internship.setDuration(request.getDuration());
        internship.setCompensation(request.getCompensation());
        internship.setDescription(request.getDescription());

        return internshipRepository.save(internship);
    }
}