package pl.mikolaj.springbootrest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienJpaRepository extends JpaRepository<Alien, Integer> {
}
