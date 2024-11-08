package co.edu.ufps.service;


import co.edu.ufps.entity.Department;
import co.edu.ufps.entity.Employee;
import co.edu.ufps.entity.Project;
import co.edu.ufps.entity.ProjectAssignment;
import co.edu.ufps.entity.Role;
import co.edu.ufps.repository.DepartmentRepository;
import co.edu.ufps.repository.EmployeeRepository;
import co.edu.ufps.repository.ProjectRepository;
import co.edu.ufps.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private RoleRepository roleRepository;

    // a. Listar los empleados
    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    // d. Actualizar un empleado
    @Transactional
    public Employee updateEmployee(Employee employee) {
        if (employee.getId() == null) {
            throw new IllegalArgumentException("Employee ID cannot be null for update operation");
        }
        return employeeRepository.save(employee);
    }

    // e. Buscar un empleado e incluir su salario
    public Optional<EmployeeWithSalary> findEmployeeWithSalary(Integer id) {
        return employeeRepository.findById(id)
                .map(employee -> new EmployeeWithSalary(employee, employee.getPosition().getSalary()));
    }

    // f. Agregar un empleado a un proyecto con un rol específico
    @Transactional
    public void addEmployeeToProject(Integer employeeId, Integer projectId, Integer roleId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        ProjectAssignment assignment = new ProjectAssignment();
        assignment.setEmployee(employee);
        assignment.setProject(project);
        assignment.setRole(role);

        project.getProjectAssignments().add(assignment);
        projectRepository.save(project);
    }

    // g. Agregar departamentos a un empleado
    @Transactional
    public void addDepartmentToEmployee(Integer employeeId, Integer departmentId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    // i. Desasociar un departamento de un empleado
    @Transactional
    public void removeDepartmentFromEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setDepartment(null);
        employeeRepository.save(employee);
    }

    // Clase interna para representar un empleado con su salario
    public static class EmployeeWithSalary {
        private Employee employee;
        private Double salary;

        public EmployeeWithSalary(Employee employee, Double salary) {
            this.employee = employee;
            this.salary = salary;
        }

        // Getters y setters
    }
}