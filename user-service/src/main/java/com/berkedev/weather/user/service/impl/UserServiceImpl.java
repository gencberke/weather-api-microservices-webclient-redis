package com.berkedev.weather.user.service.impl;

import com.berkedev.weather.user.data.dto.response.UserResponse;
import com.berkedev.weather.user.data.entity.User;
import com.berkedev.weather.user.data.mapper.UserMapper;
import com.berkedev.weather.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public UserResponse getProfile(User user) {
        return userMapper.toResponse(user);
    }
}
