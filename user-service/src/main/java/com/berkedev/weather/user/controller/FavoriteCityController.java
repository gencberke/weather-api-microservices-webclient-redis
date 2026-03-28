package com.berkedev.weather.user.controller;

import com.berkedev.weather.user.data.dto.request.AddFavoriteCityRequest;
import com.berkedev.weather.user.data.dto.response.FavoriteCityResponse;
import com.berkedev.weather.user.data.entity.User;
import com.berkedev.weather.user.service.FavoriteCityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteCityController {

    private final FavoriteCityService favoriteCityService;

    @PostMapping
    public ResponseEntity<FavoriteCityResponse> addFavoriteCity(@Valid @RequestBody AddFavoriteCityRequest request) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.status(HttpStatus.CREATED).body(favoriteCityService.addFavoriteCity(user, request));
    }

    @GetMapping
    public ResponseEntity<List<FavoriteCityResponse>> getFavoriteCities() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(favoriteCityService.getFavoriteCities(user));
    }
}
