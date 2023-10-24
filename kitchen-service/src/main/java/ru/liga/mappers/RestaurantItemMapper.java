package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.entities.RestauranMenuItemsEntity;
//Класс для преобразования сущностеи из базы данных в формы представления и наоборот (меню ресторана)
@Mapper(componentModel = "spring")
public interface RestaurantItemMapper {

    RestauranMenuItemsEntity dtoToEntity (RestauranMenuItemsDto restauranMenuItemsDto);

    RestauranMenuItemsDto entityToDto (RestauranMenuItemsEntity restauranMenuItemsEntity);




}
