package pl.mikolaj.springsecex.service;

import org.springframework.stereotype.Service;
import pl.mikolaj.springsecex.model.User;
import pl.mikolaj.springsecex.repo.UserRepo;

@Service
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User register(User user) {
        return repo.save(user);
    }
}
