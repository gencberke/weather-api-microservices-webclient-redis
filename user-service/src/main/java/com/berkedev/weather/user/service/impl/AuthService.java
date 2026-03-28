package com.berkedev.weather.user.service.impl;

import com.berkedev.weather.user.data.dto.request.PasswordResetRequest;
import com.berkedev.weather.user.data.dto.request.RegLogRequest;
import com.berkedev.weather.user.data.dto.response.AuthResponse;
import com.berkedev.weather.user.data.entity.User;
import com.berkedev.weather.user.data.mapper.UserMapper;
import com.berkedev.weather.user.data.repository.UserRepository;
import com.berkedev.weather.user.exception.BadRequestException;
import com.berkedev.weather.user.exception.DuplicateResourceException;
import com.berkedev.weather.user.exception.ResourceNotFoundException;
import com.berkedev.weather.user.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements com.berkedev.weather.user.service.AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public AuthResponse register(RegLogRequest request) {
        if (userRepository.existsByEmail(request.getEmail())){
            throw new DuplicateResourceException("Email", request.getEmail());
        }

        User newUser = userMapper.toEntity(request);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(newUser);

        return AuthResponse.builder()
                .token(jwtService.generateToken(newUser))
                .role(newUser.getRole().name())
                .email(newUser.getEmail())
                .build();
    }

    @Override
    public AuthResponse login(RegLogRequest request) {
        User dbUser = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Email not found"));

        if (!passwordEncoder.matches(request.getPassword(), dbUser.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        return AuthResponse.builder()
                .token(jwtService.generateToken(dbUser))
                .role(dbUser.getRole().name())
                .email(dbUser.getEmail())
                .build();
    }

    @Override
    public Boolean resetPassword(User user, PasswordResetRequest request) {

        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);

        return true;
    }
}
