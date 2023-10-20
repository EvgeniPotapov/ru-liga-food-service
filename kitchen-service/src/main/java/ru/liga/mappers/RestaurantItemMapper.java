package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.entities.RestauranMenuItemsEntity;

@Mapper(componentModel = "spring")
public interface RestaurantItemMapper {

    RestauranMenuItemsEntity dtoToEntity (RestauranMenuItemsDto restauranMenuItemsDto);

    RestauranMenuItemsDto entityToDto (RestauranMenuItemsEntity restauranMenuItemsEntity);




}
