package com.berkedev.weather.user.data.dto.response;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteCityResponse {
    private Long id;
    private String email;
    private String cityName;
}
