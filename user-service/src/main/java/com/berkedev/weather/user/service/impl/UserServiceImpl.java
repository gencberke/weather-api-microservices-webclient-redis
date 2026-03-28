package com.berkedev.weather.user.service.impl;

import com.berkedev.weather.user.data.mapper.UserMapper;
import com.berkedev.weather.user.data.repository.UserRepository;
import com.berkedev.weather.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthService authService;
}
