package co.edu.ufps.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    
    @Column(length = 50)
    private String firstName;
    
    @Column(length = 50)
    private String lastName;
    
    private LocalDate birthdate;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    
    private LocalDate entryDate;
    
    @OneToMany(mappedBy = "employee")
    private List<ProjectAssignment> projectAssignments;
    
    @OneToMany(mappedBy = "chief")
    private List<Department> managedDepartments;
}