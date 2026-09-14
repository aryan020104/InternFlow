package com.internflow.internflow_backend.security;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;
import com.internflow.internflow_backend.entity.Role;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;

@Component
public class JwtService {
    private final SecretKey secretKey = Keys.hmacShaKeyFor(
            "this-is-a-very-long-secret-key-for-jwt-signing-please-change-me".getBytes());

    public String generateToken(UUID userId, Role role) {
        return Jwts.builder()
                .subject(userId.toString())
                .claim("role", role.name())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(secretKey)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
