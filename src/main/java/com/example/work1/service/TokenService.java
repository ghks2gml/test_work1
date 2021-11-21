package com.example.work1.service;

import com.example.work1.exception.ServerException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@Slf4j
public class TokenService {
    @Value("${jwt.access.token.key}")
    private String accessTokenKey;

    private static final int ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 3;

    public void validToken(String token) {
        Jws<Claims> claims = null;
        try {
            claims = Jwts.parser().setSigningKey(accessTokenKey.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token);
        } catch (MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
            throw new ServerException(502, "잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
            throw new ServerException(503, "만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
            throw new ServerException(504, "지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
            throw new ServerException(505, "JWT 토큰이 잘못되었습니다.");
        }
    }

    public String token(int memberId) {
        return Jwts.builder()
                .setSubject(String.valueOf(memberId))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRE_TIME))
                .compact();
    }

    public int getMemberId(String accessToken){
        Claims claims = parseClaims(accessToken);
        return Integer.parseInt(claims.getSubject());
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parser().setSigningKey(accessTokenKey).parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}