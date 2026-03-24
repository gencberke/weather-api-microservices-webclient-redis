package com.berkedev.weather.user.data.dto.response;

import com.berkedev.weather.user.data.enums.Role;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String email;
    private String unit;
    private String role;
}
