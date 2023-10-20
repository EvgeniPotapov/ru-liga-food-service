package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestauranMenuItemsDto {

    private long id;
    private long restaurantId;
    private String name;

    private double price;

    private String image;

    private String description;
}
