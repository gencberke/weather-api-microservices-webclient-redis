package com.berkedev.weather.user.service;

import com.berkedev.weather.user.data.dto.request.PasswordResetRequest;
import com.berkedev.weather.user.data.dto.request.RegLogRequest;
import com.berkedev.weather.user.data.dto.response.AuthResponse;
import com.berkedev.weather.user.data.entity.User;

public interface AuthService {
    AuthResponse register(RegLogRequest request);
    AuthResponse login(RegLogRequest request);
    Boolean resetPassword(User user, PasswordResetRequest request);
}
