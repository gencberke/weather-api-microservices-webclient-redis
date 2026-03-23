package com.berkedev.weather.user.data.repository;

import com.berkedev.weather.user.data.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findUserByEmail(String email);
    boolean existsByEmail(String email);
}
