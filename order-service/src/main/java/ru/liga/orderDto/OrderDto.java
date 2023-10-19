package ru.liga.orderDto;

import lombok.Getter;
import lombok.Setter;
import ru.liga.model.Menu_Items;
import ru.liga.model.RestoranName;

@Getter
@Setter
public class OrderDto {



    private long id;
    private RestoranName restaurant;
    private int timestamp;
    private Menu_Items items;





}
