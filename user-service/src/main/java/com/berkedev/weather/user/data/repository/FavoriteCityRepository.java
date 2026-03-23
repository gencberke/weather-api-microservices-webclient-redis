package com.berkedev.weather.user.data.repository;

import com.berkedev.weather.user.data.entity.FavoriteCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteCityRepository extends BaseRepository<FavoriteCity> {
    List<FavoriteCity> findByUserId(Long userId);

    boolean existsByCityNameAndUserId(String cityName,Long userId);
}
