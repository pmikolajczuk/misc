package pl.mikolaj.springbootrest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class AlienResource {

    private final AlienJpaRepository repo;

    @Autowired
    public AlienResource(AlienJpaRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/aliens")
    public List<Alien> getAliens() {
        return repo.findAll();
    }

    @GetMapping("/aliens/{id}")
    public ResponseEntity<Alien> getAlien(@PathVariable("id") int id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/aliens")
    public Alien createAlien(@RequestBody Alien alien) {
        return repo.save(alien);
    }

    @PutMapping("/aliens")
    public Alien updateAlien(@RequestBody Alien alien) {
        return repo.save(alien);
    }

    @DeleteMapping("/aliens/{id}")
    public ResponseEntity<String> deleteAlien(@PathVariable("id") int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok("Deleted alien with id: " + id);
        }
        return ResponseEntity.notFound().build();
    }
}
