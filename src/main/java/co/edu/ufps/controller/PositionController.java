package co.edu.ufps.controller;



import co.edu.ufps.entity.Position;
import co.edu.ufps.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/positions")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable Integer id) {
        return positionService.findPositionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}