package ru.liga.orderDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderMenuDto {

    private long id;
    private RestoranName restaurant;
    private int timestamp;
    private MenuItems items;





}
