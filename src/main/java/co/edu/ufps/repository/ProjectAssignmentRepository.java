package co.edu.ufps.repository;

import co.edu.ufps.entity.ProjectAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectAssignmentRepository extends JpaRepository<ProjectAssignment, Integer> {
}