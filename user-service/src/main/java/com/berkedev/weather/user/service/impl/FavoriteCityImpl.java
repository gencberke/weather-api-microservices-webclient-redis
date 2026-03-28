package com.berkedev.weather.user.service.impl;

import com.berkedev.weather.user.data.dto.request.AddFavoriteCityRequest;
import com.berkedev.weather.user.data.dto.response.FavoriteCityResponse;
import com.berkedev.weather.user.data.entity.FavoriteCity;
import com.berkedev.weather.user.data.entity.User;
import com.berkedev.weather.user.data.mapper.FavoriteCityMapper;
import com.berkedev.weather.user.data.repository.FavoriteCityRepository;
import com.berkedev.weather.user.exception.DuplicateResourceException;
import com.berkedev.weather.user.service.FavoriteCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteCityImpl implements FavoriteCityService {

    private final FavoriteCityMapper favoriteCityMapper;
    private final FavoriteCityRepository favoriteCityRepository;

    @Override
    public FavoriteCityResponse addFavoriteCity(User user, AddFavoriteCityRequest request) {
        if (favoriteCityRepository.existsByCityNameAndUserId(request.getCityName(), user.getId())) {
            throw new DuplicateResourceException("City named: " + request.getCityName() + " already exists");
        }

        FavoriteCity favoriteCity = favoriteCityMapper.toEntity(request);
        favoriteCity.setUser(user);
        favoriteCityRepository.save(favoriteCity);

        return favoriteCityMapper.toResponse(favoriteCity);
    }

    @Override
    public List<FavoriteCityResponse> getFavoriteCities(User user) {
        return favoriteCityRepository.findByUserId(user.getId())
                .stream()
                .map(favoriteCityMapper::toResponse)
                .toList();
    }
}
