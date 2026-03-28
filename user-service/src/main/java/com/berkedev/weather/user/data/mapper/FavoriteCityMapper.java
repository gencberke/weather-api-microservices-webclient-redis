package com.berkedev.weather.user.data.mapper;

import com.berkedev.weather.user.data.dto.request.AddFavoriteCityRequest;
import com.berkedev.weather.user.data.dto.response.FavoriteCityResponse;
import com.berkedev.weather.user.data.entity.FavoriteCity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FavoriteCityMapper {

    @Mapping(target = "email", expression = "java(favoriteCity.getUser().getEmail())")
    FavoriteCityResponse toResponse(FavoriteCity favoriteCity);

    FavoriteCity toEntity(AddFavoriteCityRequest favoriteCityRequest);
}
