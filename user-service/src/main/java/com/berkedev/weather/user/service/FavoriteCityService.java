package com.berkedev.weather.user.service;

import com.berkedev.weather.user.data.dto.request.AddFavoriteCityRequest;
import com.berkedev.weather.user.data.dto.response.FavoriteCityResponse;
import com.berkedev.weather.user.data.entity.User;

import java.util.List;

public interface FavoriteCityService {
    FavoriteCityResponse addFavoriteCity(User user, AddFavoriteCityRequest request);
    List<FavoriteCityResponse> getFavoriteCities(User user);
}
