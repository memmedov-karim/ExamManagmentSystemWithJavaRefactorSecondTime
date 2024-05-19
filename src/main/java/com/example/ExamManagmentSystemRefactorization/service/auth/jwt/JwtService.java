package com.example.ExamManagmentSystemRefactorization.service.auth.jwt;

import com.example.ExamManagmentSystemRefactorization.entity.Region;
import com.example.ExamManagmentSystemRefactorization.entity.User;
import com.example.ExamManagmentSystemRefactorization.exception.CookieNotFoundException;
import com.example.ExamManagmentSystemRefactorization.exception.TokenNotFoundException;
import com.example.ExamManagmentSystemRefactorization.repository.UserRepository;
import com.example.ExamManagmentSystemRefactorization.service.region.RegionService;
import com.example.ExamManagmentSystemRefactorization.service.user.UserService;
import com.example.ExamManagmentSystemRefactorization.util.region.RegionResourceChecker;
import com.example.ExamManagmentSystemRefactorization.util.user.UserResourceChecker;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final RegionService regionService;
    private final UserResourceChecker userResourceChecker;
    private final RegionResourceChecker regionResourceChecker;
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private int jwtExpiration;

    private String generateToken(Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + (jwtExpiration * 1000));
        return Jwts.builder()
                .setSubject(Long.toString(userId))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Long getUserIdFromToken(HttpServletRequest request, String tokenName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String token = Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals(tokenName))
                    .map(Cookie::getValue)
                    .findFirst()
                    .orElseThrow(TokenNotFoundException::new);
            return this.parseTokenAndGetUserId(token);
        } else {
            throw new CookieNotFoundException();
        }
    }

    private Long parseTokenAndGetUserId(String token) throws JwtException, NumberFormatException {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        String userIdStr = claims.getSubject();
        return Long.parseLong(userIdStr);
    }

    public void sendTokenWithCookie(Long id,String tokenName, HttpServletResponse response){
        String token = this.generateToken(id);
        Cookie cookie = new Cookie(tokenName, token);
        cookie.setMaxAge(this.jwtExpiration);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setSecure(true);
        response.addCookie(cookie);
    }

    public String clearCookie(HttpServletRequest request,HttpServletResponse response,String tokenName){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(tokenName)) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    cookie.setHttpOnly(true);
                    cookie.setSecure(true);
                    response.addCookie(cookie);
                    return "Logged out successfully";
                }
            }
        }
        throw new CookieNotFoundException();
    }
}
