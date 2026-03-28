package com.berkedev.weather.user.controller;

import com.berkedev.weather.user.data.dto.request.PasswordResetRequest;
import com.berkedev.weather.user.data.dto.request.RegLogRequest;
import com.berkedev.weather.user.data.dto.response.AuthResponse;
import com.berkedev.weather.user.data.entity.User;
import com.berkedev.weather.user.service.impl.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegLogRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody RegLogRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(request));
    }

    @PutMapping("/reset-password")
    public ResponseEntity<Boolean> resetPassword(@Valid @RequestBody PasswordResetRequest request) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.status(HttpStatus.OK).body(authService.resetPassword(user, request));
    }
}
