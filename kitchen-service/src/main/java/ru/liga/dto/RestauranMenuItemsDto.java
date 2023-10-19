package ru.liga.dto;

import javax.persistence.Column;

public class RestauranMenuItemsDto {

    @Column(name = "nameitems")
    private String name;

    private double price;

    private String image;

    private String description;
}
