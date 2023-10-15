package ru.liga.orderDto;

import lombok.Getter;
import lombok.Setter;
import ru.liga.dto.ResponseItemsDto;
import ru.liga.dto.ResponseRestoranNameDto;

@Getter
@Setter
public class ResponseOrderDto {



    long id;
    ResponseRestoranNameDto restaurant;
    int timestamp;
    ResponseItemsDto items;



}
