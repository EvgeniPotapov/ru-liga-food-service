package ru.liga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseOrderItemDto {
    private long id;
    RequestMenu_itemsDto menu_items;
}
