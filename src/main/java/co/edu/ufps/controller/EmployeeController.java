package co.edu.ufps.controller;



import co.edu.ufps.entity.Employee;
import co.edu.ufps.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.listAllEmployees();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        employee.setId(id);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @GetMapping("/{id}/with-salary")
    public ResponseEntity<EmployeeService.EmployeeWithSalary> getEmployeeWithSalary(@PathVariable Integer id) {
        return employeeService.findEmployeeWithSalary(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{employeeId}/projects/{projectId}/roles/{roleId}")
    public ResponseEntity<Void> addEmployeeToProject(
            @PathVariable Integer employeeId,
            @PathVariable Integer projectId,
            @PathVariable Integer roleId) {
        employeeService.addEmployeeToProject(employeeId, projectId, roleId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{employeeId}/departments/{departmentId}")
    public ResponseEntity<Void> addDepartmentToEmployee(
            @PathVariable Integer employeeId,
            @PathVariable Integer departmentId) {
        employeeService.addDepartmentToEmployee(employeeId, departmentId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{employeeId}/departments")
    public ResponseEntity<Void> removeDepartmentFromEmployee(@PathVariable Integer employeeId) {
        employeeService.removeDepartmentFromEmployee(employeeId);
        return ResponseEntity.ok().build();
    }
}