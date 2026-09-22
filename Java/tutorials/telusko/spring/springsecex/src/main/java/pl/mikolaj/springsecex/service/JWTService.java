package pl.mikolaj.springsecex.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class JWTService {
    private static final long EXPIRATION_MS = 1000L * 60 * 60; // 1 hour

    public String generateToken(String username) {
        Map<String, Object> claims = Map.of("username", username);

        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor("mysecretkeymysecretkeymysecretkeymysecretkey".getBytes());
    }

    public Optional<String> extractUserName(String jwtToken) {
        try {
            String subject = Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(jwtToken)
                    .getPayload()
                    .getSubject();
            return Optional.ofNullable(subject);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        return extractUserName(token)
                .map(username -> username.equals(userDetails.getUsername()))
                .orElse(false);
    }
}