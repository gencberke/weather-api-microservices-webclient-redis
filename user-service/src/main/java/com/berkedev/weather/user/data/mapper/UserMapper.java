package com.berkedev.weather.user.data.mapper;

import com.berkedev.weather.user.data.dto.request.RegLogRequest;
import com.berkedev.weather.user.data.dto.response.UserResponse;
import com.berkedev.weather.user.data.entity.User;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", expression = "java(user.getRole() != null ? user.getRole().name() : null)")
    UserResponse toResponse(User user);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "unit", ignore = true)
    @Mapping(target = "favoriteCities", ignore = true)
    User toEntity(RegLogRequest request);
}
