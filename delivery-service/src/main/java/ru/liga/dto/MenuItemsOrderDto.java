package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//Клвсс для принятия заказа клиента из кухонного сервиса
public class MenuItemsOrderDto {

    private long id;

    private long orderId;

    private long restaurantMenuItems;

    private BigDecimal price;

    private int quantitu;
}
