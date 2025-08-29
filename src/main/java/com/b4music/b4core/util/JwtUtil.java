package com.b4music.b4core.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret.key}")
    private String SECRET_KEY;

    public String generateToken (String email) {
        return Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .compact();
    }

    public String extractToken (String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
