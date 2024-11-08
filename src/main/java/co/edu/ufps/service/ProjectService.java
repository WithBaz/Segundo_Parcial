package co.edu.ufps.service;

import co.edu.ufps.entity.Employee;
import co.edu.ufps.entity.Project;
import co.edu.ufps.entity.Role;
import co.edu.ufps.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // c. Crear un proyecto
    @Transactional
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // h. Listar los empleados de un proyecto con su respectivo rol
    public List<EmployeeProjectRole> listEmployeesInProject(Integer projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        return project.getProjectAssignments().stream()
                .map(assignment -> new EmployeeProjectRole(
                        assignment.getEmployee(),
                        project,
                        assignment.getRole()))
                .collect(Collectors.toList());
    }

    // Clase interna para representar un empleado en un proyecto con su rol
    public static class EmployeeProjectRole {
        private Employee employee;
        private Project project;
        private Role role;

        public EmployeeProjectRole(Employee employee, Project project, Role role) {
            this.employee = employee;
            this.project = project;
            this.role = role;
        }

        // Getters y setters
    }
}