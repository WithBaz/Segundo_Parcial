package co.edu.ufps.controller;


import co.edu.ufps.entity.ProjectAssignment;
import co.edu.ufps.repository.ProjectAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project-assignments")
public class ProjectAssignmentController {
    @Autowired
    private ProjectAssignmentRepository projectAssignmentRepository;

    @GetMapping
    public List<ProjectAssignment> getAllProjectAssignments() {
        return projectAssignmentRepository.findAll();
    }

    @PostMapping
    public ProjectAssignment createProjectAssignment(@RequestBody ProjectAssignment projectAssignment) {
        return projectAssignmentRepository.save(projectAssignment);
    }
}