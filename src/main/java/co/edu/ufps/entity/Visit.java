package co.edu.ufps.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(VisitId.class)
public class Visit {
    @Id
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}