package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.entities.OrdersEntity;
import ru.liga.orderDto.OrderDto;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrdersEntity dtoToEntity (OrderDto orderDto);

    OrderDto entityToDto (OrdersEntity ordersEntity);
}
