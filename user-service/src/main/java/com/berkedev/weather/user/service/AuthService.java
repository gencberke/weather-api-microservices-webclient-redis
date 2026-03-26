package com.berkedev.weather.user.service;

import com.berkedev.weather.user.data.dto.request.RegLogRequest;
import com.berkedev.weather.user.data.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegLogRequest request);
    AuthResponse login(RegLogRequest request);
}
