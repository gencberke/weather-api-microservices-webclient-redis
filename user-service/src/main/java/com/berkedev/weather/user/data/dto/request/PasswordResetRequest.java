package com.berkedev.weather.user.data.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasswordResetRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String oldPassword;

    @Size(min = 8, message = "Password must be at least 8 character long")
    private String newPassword;
}
