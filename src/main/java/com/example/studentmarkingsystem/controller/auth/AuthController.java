package com.example.studentmarkingsystem.controller.auth;

import com.example.studentmarkingsystem.dto.auth.AuthRequest;
import com.example.studentmarkingsystem.dto.auth.AuthResponse;
import com.example.studentmarkingsystem.entity.RefreshToken;
import com.example.studentmarkingsystem.service.JWTService;
import com.example.studentmarkingsystem.service.JWTService;
import com.example.studentmarkingsystem.service.detailService.GeneralUserDetailService;
import com.example.studentmarkingsystem.repository.RefreshTokenRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.UUID;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final GeneralUserDetailService userDetailsService;
    private final JWTService jwtService;
    private final RefreshTokenRepository refreshTokenRepository;

    public AuthController(AuthenticationManager authenticationManager, GeneralUserDetailService userDetailsService, JWTService jwtService, RefreshTokenRepository refreshTokenRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
            String accessToken = jwtService.generateToken(authRequest.getUsername());
            String refreshTokenValue = UUID.randomUUID().toString(); // Generate a unique refresh token

            RefreshToken refreshToken = new RefreshToken();
            refreshToken.setToken(refreshTokenValue);
            refreshToken.setUsername(authRequest.getUsername());
            refreshToken.setExpiryDate(Instant.now().plusMillis(jwtService.getRefreshTokenExpirationMs())); // Implement this in JwtService
            refreshTokenRepository.save(refreshToken);

            return ResponseEntity.ok(new AuthResponse(accessToken, refreshTokenValue));
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
