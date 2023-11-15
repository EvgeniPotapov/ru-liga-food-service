package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderItemDto;
import ru.liga.entities.OrderEntity;
import ru.liga.entities.OrderItemsEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity dtoToEntity (OrderDto orderDto);

    OrderDto entityToDto (OrderEntity orderEntity);

    OrderItemsEntity dtoToEntity (OrderItemDto orderItemDto);

    OrderItemDto dtoToEntity (OrderItemsEntity orderItemsEntity);
}
