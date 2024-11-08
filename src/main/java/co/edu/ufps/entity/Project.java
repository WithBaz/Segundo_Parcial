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
import jakarta.persistence.OneToMany;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    
    @Column(length = 200)
    private String name;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    private LocalDate startDate;
    private LocalDate endDate;
    
    @OneToMany(mappedBy = "project")
    private List<ProjectAssignment> projectAssignments;
}