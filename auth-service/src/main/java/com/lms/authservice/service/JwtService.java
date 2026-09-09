package com.lms.authservice.service;

import com.lms.authservice.config.JwtProperties;
import com.lms.authservice.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtProperties jwtProperties;

    public String generateToken(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("userId", user.getId());
        extraClaims.put("role", user.getRole().name()); // convert the enum value into string using  name() method

        long now = System.currentTimeMillis();

        return Jwts.builder()
                .claims(extraClaims)
                .subject(user.getEmail()) //sub is the standard JWT claim used to identify the subject (usually the user) that the token represents.
                .issuedAt(new Date(now))
                .expiration(new Date(now + jwtProperties.getExpiration()))
                .signWith(getSigningKey())
                .compact();
    }

    public long getExpirationTime() {
        return jwtProperties.getExpiration();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = jwtProperties.getSecretKey().getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}