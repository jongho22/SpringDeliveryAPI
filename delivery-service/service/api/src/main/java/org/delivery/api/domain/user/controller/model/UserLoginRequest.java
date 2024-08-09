package org.delivery.api.domain.user.controller.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
