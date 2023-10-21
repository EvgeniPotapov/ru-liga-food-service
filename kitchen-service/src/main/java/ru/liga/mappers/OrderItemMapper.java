package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.dto.MenuItemsOrderDto;
import ru.liga.entities.OrderItemsEntity;
import ru.liga.entities.RestauranMenuItemsEntity;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemsEntity dtoToEntity (MenuItemsOrderDto menuItemsOrder);

    MenuItemsOrderDto entityToDto (OrderItemsEntity orderItemsEntity);

}
