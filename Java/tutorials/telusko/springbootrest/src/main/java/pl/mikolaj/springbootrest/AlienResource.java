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

@RestController
@RequestMapping("/api")
public class AlienResource {

    private final AlienRepository repo;

    @Autowired
    public AlienResource(AlienRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/aliens")
    public List<Alien> getAliens() {
        return repo.getAliens();
    }

    @GetMapping("/aliens/{id}")
    public Alien getAlien(@PathVariable("id") int id) {
        return repo.getAlien(id);
    }

    @PostMapping("/aliens")
    public Alien createAlien(@RequestBody Alien alien) {
        repo.create(alien);
        return alien;
    }

    @PutMapping("/aliens")
    public Alien updateAlien(@RequestBody Alien alien) {
        repo.update(alien);
        return alien;
    }

    @DeleteMapping("/aliens/{id}")
    public String deleteAlien(@PathVariable("id") int id) {
        repo.delete(id);
        return "Deleted alien with id: " + id;
    }
}
