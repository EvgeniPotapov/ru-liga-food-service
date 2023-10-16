package ru.liga.orderDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {



    long id;
    RestoranNameDto restaurant;
    int timestamp;
    ItemsDto items;



}
