package ru.liga.dto;

import lombok.Data;

@Data
public class RegistrationUserDto {


    private String name;

    private String password;

    private String confirmPassword;
}
