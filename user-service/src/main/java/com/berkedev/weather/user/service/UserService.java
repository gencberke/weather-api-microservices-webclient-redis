package com.berkedev.weather.user.service;

import com.berkedev.weather.user.data.dto.response.UserResponse;
import com.berkedev.weather.user.data.entity.User;

public interface UserService {
    UserResponse getProfile(User user);
}
