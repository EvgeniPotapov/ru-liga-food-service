package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.dto.OrderDto;
import ru.liga.entities.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderEntity dtoToEntity (OrderDto orderDto);

    OrderDto entityToDto (OrderEntity orderEntity);
}
