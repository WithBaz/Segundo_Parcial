package co.edu.ufps.controller;




import co.edu.ufps.entity.Project;
import co.edu.ufps.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return ResponseEntity.ok(createdProject);
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<List<ProjectService.EmployeeProjectRole>> getEmployeesInProject(@PathVariable Integer id) {
        List<ProjectService.EmployeeProjectRole> employees = projectService.listEmployeesInProject(id);
        return ResponseEntity.ok(employees);
    }
}