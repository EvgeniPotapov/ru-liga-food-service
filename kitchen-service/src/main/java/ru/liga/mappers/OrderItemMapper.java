package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.dto.MenuItemsOrderDto;
import ru.liga.entities.OrderItemsEntity;

//интерфейс для преобразования сущностеи из базы данных в формы представления и наоборот(заказ клиента)
@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemsEntity dtoToEntity (MenuItemsOrderDto menuItemsOrder);

    MenuItemsOrderDto entityToDto (OrderItemsEntity orderItemsEntity);

}
