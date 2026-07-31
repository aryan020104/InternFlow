package com.internflow.internflow_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internflow.internflow_backend.entity.Internship;
import com.internflow.internflow_backend.repository.InternshipRepository;

@Service
public class InternshipService {

    @Autowired
    private InternshipRepository internshipRepository;

    public List<Internship> getAllInternships() {
        return internshipRepository.findAll();
    }

    public Internship getInternshipById(Long id) {
        return internshipRepository.findById(id).orElse(null);
    }

    public Internship saveInternship(Internship internship) {
        return internshipRepository.save(internship);
    }

    public Internship updateInternship(Long id, Internship updatedInternship) {

        Internship internship = internshipRepository.findById(id).orElse(null);

        if (internship == null) {
            return null;
        }

        internship.setCompanyName(updatedInternship.getCompanyName());
        internship.setJobTitle(updatedInternship.getJobTitle());
        internship.setLocation(updatedInternship.getLocation());
        internship.setSalary(updatedInternship.getSalary());
        internship.setStatus(updatedInternship.getStatus());
        internship.setApplicationDate(updatedInternship.getApplicationDate());
        internship.setDeadline(updatedInternship.getDeadline());
        internship.setNotes(updatedInternship.getNotes());

        return internshipRepository.save(internship);
    }

    public void deleteInternship(Long id) {
        internshipRepository.deleteById(id);
    }
}
