package ru.liga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    private long id;
    MenuItems menuItems;
}
