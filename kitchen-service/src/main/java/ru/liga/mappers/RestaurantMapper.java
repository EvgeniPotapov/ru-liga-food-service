package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.dto.MenuItemsOrderDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.entities.OrderItemsEntity;
import ru.liga.entities.RestaurantEntity;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantEntity dtoToEntity (RestaurantDto restaurantDto);

    RestaurantDto entityToDto (RestaurantEntity restaurant);
}
