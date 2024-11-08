package co.edu.ufps.service;



import co.edu.ufps.entity.Position;
import co.edu.ufps.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    // b. Buscar una posición por id
    public Optional<Position> findPositionById(Integer id) {
        return positionRepository.findById(id);
    }
}
