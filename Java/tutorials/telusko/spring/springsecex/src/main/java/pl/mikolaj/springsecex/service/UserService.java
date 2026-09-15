package pl.mikolaj.springsecex.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mikolaj.springsecex.model.User;
import pl.mikolaj.springsecex.repo.UserRepo;

@Service
public class UserService {

    private final UserRepo repo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepo repo, BCryptPasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
