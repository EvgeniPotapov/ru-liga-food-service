package ru.liga.orderDto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ItemsDto {

    private BigDecimal price;
    private String image;
    private String description;
    private int quantity;
}
