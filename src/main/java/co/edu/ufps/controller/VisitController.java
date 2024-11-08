package co.edu.ufps.controller;


import co.edu.ufps.entity.Visit;
import co.edu.ufps.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {
    @Autowired
    private VisitRepository visitRepository;

    @GetMapping
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    @PostMapping
    public Visit createVisit(@RequestBody Visit visit) {
        return visitRepository.save(visit);
    }
}
