package com.internflow.internflow_backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.dto.InternshipCreateRequest;
import com.internflow.internflow_backend.dto.InternshipResponse;
import com.internflow.internflow_backend.dto.InternshipUpdateRequest;
import com.internflow.internflow_backend.entity.Internship;
import com.internflow.internflow_backend.entity.Role;
import com.internflow.internflow_backend.entity.User;
import com.internflow.internflow_backend.exception.UnauthorizedRoleException;
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

    public List<InternshipResponse> getAllInternships() {

        return internshipRepository.findAll()
                .stream()
                .map(internship -> {
                    InternshipResponse response = new InternshipResponse();
                    response.setId(internship.getId());
                    response.setTitle(internship.getTitle());
                    response.setField(internship.getField());
                    response.setLocation(internship.getLocation());
                    response.setDuration(internship.getDuration());
                    response.setCompensation(internship.getCompensation());
                    response.setDescription(internship.getDescription());
                    response.setStatus(internship.getStatus());
                    response.setPostedAt(internship.getPostedAt());

                    return response;
                })
                .toList();
    }

    public InternshipResponse getInternshipById(UUID id) {

        Internship internship = internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found: " + id));

        InternshipResponse response = new InternshipResponse();

        response.setId(internship.getId());
        response.setTitle(internship.getTitle());
        response.setField(internship.getField());
        response.setLocation(internship.getLocation());
        response.setDuration(internship.getDuration());
        response.setCompensation(internship.getCompensation());
        response.setDescription(internship.getDescription());
        response.setStatus(internship.getStatus());
        response.setPostedAt(internship.getPostedAt());

        return response;
    }

    public Internship createInternship(InternshipCreateRequest request, UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));

        if (user.getRole() != Role.COMPANY) {
            throw new UnauthorizedRoleException(
                    "Only companies can create internships");
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

    public void deleteInternship(UUID id, UUID userId) {

        Internship internship = internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found: " + id));

        if (!internship.getUser().getId().equals(userId)) {
            throw new UnauthorizedRoleException(
                    "You can only delete your own internships");
        }

        internshipRepository.delete(internship);
    }

    public InternshipResponse updateInternship(
            UUID id,
            InternshipUpdateRequest request,
            UUID userId) {

        Internship internship = internshipRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found: " + id));

        if (!internship.getUser().getId().equals(userId)) {
            throw new UnauthorizedRoleException(
                    "You can only update your own internships");
        }

        internship.setTitle(request.getTitle());
        internship.setField(request.getField());
        internship.setLocation(request.getLocation());
        internship.setDuration(request.getDuration());
        internship.setCompensation(request.getCompensation());
        internship.setDescription(request.getDescription());

        Internship updatedInternship = internshipRepository.save(internship);

        InternshipResponse response = new InternshipResponse();

        response.setId(updatedInternship.getId());
        response.setTitle(updatedInternship.getTitle());
        response.setField(updatedInternship.getField());
        response.setLocation(updatedInternship.getLocation());
        response.setDuration(updatedInternship.getDuration());
        response.setCompensation(updatedInternship.getCompensation());
        response.setDescription(updatedInternship.getDescription());
        response.setStatus(updatedInternship.getStatus());
        response.setPostedAt(updatedInternship.getPostedAt());

        return response;
    }
}