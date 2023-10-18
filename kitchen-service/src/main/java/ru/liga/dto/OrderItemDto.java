package ru.liga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {
    private long id;
    Menu_itemsDto menu_items;
}
