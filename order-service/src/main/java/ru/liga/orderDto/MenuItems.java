package ru.liga.orderDto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter

public class MenuItems {

    private BigDecimal price;
    private int quantity;
    private String description;
    private String image;


}
