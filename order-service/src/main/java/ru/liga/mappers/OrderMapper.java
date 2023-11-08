package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.entities.OrderEntity;

import ru.liga.entities.OrderItemsEntity;
import ru.liga.orderDto.OrderDto;
import ru.liga.orderDto.OrderItemDto;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity dtoToEntity (OrderDto orderDto);

    OrderDto entityToDto (OrderEntity orderEntity);

    OrderItemsEntity dtoToEntity (OrderItemDto orderItemDto);

    OrderItemDto dtoToEntity (OrderItemsEntity orderItemsEntity);
}
