package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestauranMenuItemsDto {

    private String nameItems;

    private BigDecimal price;

    private String image;

    private String description;
}
