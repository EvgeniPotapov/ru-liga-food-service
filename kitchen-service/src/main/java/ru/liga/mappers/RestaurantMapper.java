package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.entities.RestauranMenuItemsEntity;
import ru.liga.entities.RestaurantEntity;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    /////////////////////////методы для перевода из Dto в Entity////////////////////////////

    RestaurantEntity dtoToEntity (RestaurantDto restaurantDto);

    RestaurantDto entityToDto (RestaurantEntity restaurantEntity);

    RestauranMenuItemsEntity dtoToEntity (RestauranMenuItemsDto restauranMenuItemsDto);

    RestauranMenuItemsDto dtoToEntity (RestauranMenuItemsEntity restauranMenuItemsEntity);
}
