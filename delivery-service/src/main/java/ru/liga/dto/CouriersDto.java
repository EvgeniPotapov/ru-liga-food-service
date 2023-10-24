package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CouriersDto {

    private long id;

    private String phone;

    private String status;

    private String coordinates;
}
