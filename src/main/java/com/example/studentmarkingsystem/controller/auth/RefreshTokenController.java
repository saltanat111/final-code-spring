package com.example.studentmarkingsystem.controller.auth;

import com.example.studentmarkingsystem.dto.auth.RefreshTokenRequest;
import com.example.studentmarkingsystem.dto.auth.AuthResponse;
import com.example.studentmarkingsystem.entity.RefreshToken;
import com.example.studentmarkingsystem.repository.RefreshTokenRepository;
import com.example.studentmarkingsystem.service.JWTService;
import com.example.studentmarkingsystem.service.JWTService;
import com.example.studentmarkingsystem.service.detailService.GeneralUserDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.UUID;

@RestController
public class RefreshTokenController {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JWTService jwtService;
    private final GeneralUserDetailService userDetailsService;

    public RefreshTokenController(RefreshTokenRepository refreshTokenRepository, JWTService jwtService, GeneralUserDetailService userDetailsService) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/api/auth/refresh")
    public ResponseEntity<?> refreshAccessToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return refreshTokenRepository.findByToken(refreshTokenRequest.getRefreshToken())
                .map(refreshToken -> {
                    if (refreshToken.getExpiryDate().isBefore(Instant.now())) {
                        refreshTokenRepository.delete(refreshToken);
                        return new ResponseEntity<>("Refresh token was expired. Please make a new sign-in request", HttpStatus.FORBIDDEN);
                    }
                    // Generate new access token
                    String newAccessToken = jwtService.generateToken(refreshToken.getUsername());
                    // Optionally generate a new refresh token and update the database
                    String newRefreshTokenValue = UUID.randomUUID().toString();
                    refreshToken.setToken(newRefreshTokenValue);
                    refreshToken.setExpiryDate(Instant.now().plusMillis(jwtService.getRefreshTokenExpirationMs()));
                    refreshTokenRepository.save(refreshToken);

                    return ResponseEntity.ok(new AuthResponse(newAccessToken, newRefreshTokenValue));
                })
                .orElseGet(() -> new ResponseEntity<>("Invalid refresh token", HttpStatus.NOT_FOUND));
    }
}