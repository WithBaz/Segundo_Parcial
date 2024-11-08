package co.edu.ufps.repository;


import co.edu.ufps.entity.Visit;
import co.edu.ufps.entity.VisitId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, VisitId> {
}