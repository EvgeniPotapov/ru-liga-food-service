package ru.liga.orderDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {



    private long id;
    private RestoranName restaurant;
    private int timestamp;
    private Menu_Items items;





}
