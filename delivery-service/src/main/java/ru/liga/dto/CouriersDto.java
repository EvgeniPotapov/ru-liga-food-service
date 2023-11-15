package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CouriersDto {

    private String phone;

    private String status;

    private String coordinates;

    private String firstName;

    private String lastName;
}
