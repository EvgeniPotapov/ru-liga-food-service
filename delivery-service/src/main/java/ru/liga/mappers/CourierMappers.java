package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.dto.CouriersDto;
import ru.liga.dto.OrderDto;
import ru.liga.dto.OrderItemDto;
import ru.liga.entities.CourierEntity;
import ru.liga.entities.OrderEntity;
import ru.liga.entities.OrderItemsEntity;

@Mapper(componentModel = "spring")
public interface CourierMappers {

    CourierEntity dtoToEntity (CouriersDto couriersDto);

    CouriersDto entityToDto (CourierEntity courierEntity);

}
