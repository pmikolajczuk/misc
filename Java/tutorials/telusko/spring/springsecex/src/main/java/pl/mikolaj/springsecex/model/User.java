package pl.mikolaj.springsecex.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
}
