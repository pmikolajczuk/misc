package pl.mikolaj.restjersey;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
    List<Alien> aliens;

    public AlienRepository() {
        aliens = new ArrayList<>(List.of(
                new Alien(101, "Zorg", 60),
                new Alien(102, "Xenon", 80)
        ));
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public Alien getAlien(int id) {
        return aliens.stream()
                .filter(alien -> alien.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void create(Alien alien) {
        aliens.add(alien);
    }
}
