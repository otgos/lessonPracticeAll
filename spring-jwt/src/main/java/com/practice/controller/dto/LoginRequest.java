package com.practice.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank
    @NotBlank
    private String userName;

    @NotBlank
    @NotBlank
    private String password;

}
