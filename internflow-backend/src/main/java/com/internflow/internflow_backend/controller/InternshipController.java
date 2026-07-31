package com.internflow.internflow_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internflow.internflow_backend.entity.Internship;
import com.internflow.internflow_backend.service.InternshipService;

@RestController
@RequestMapping("/api/internships")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

    @GetMapping
    public List<Internship> getAllInternships() {
        return internshipService.getAllInternships();
    }

    @GetMapping("/{id}")
    public Internship getInternshipById(@PathVariable Long id) {
        return internshipService.getInternshipById(id);
    }

    @PostMapping
    public Internship createInternship(@RequestBody Internship internship) {
        return internshipService.saveInternship(internship);
    }

    @PutMapping("/{id}")
    public Internship updateInternship(@PathVariable Long id,
                                       @RequestBody Internship internship) {
        return internshipService.updateInternship(id, internship);
    }

    @DeleteMapping("/{id}")
    public void deleteInternship(@PathVariable Long id) {
        internshipService.deleteInternship(id);
    }
}