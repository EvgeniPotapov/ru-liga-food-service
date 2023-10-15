package ru.liga.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ResponseItemsDto {

    private BigDecimal price;
    private String image;
    private String description;
    private int quantity;
}
