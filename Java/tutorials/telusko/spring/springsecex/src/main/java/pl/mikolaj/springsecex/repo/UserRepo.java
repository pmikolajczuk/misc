package pl.mikolaj.springsecex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mikolaj.springsecex.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User getByUsername(String username);
}