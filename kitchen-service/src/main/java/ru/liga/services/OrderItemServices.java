package ru.liga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.MenuItemsOrderDto;
import ru.liga.entities.OrderItemsEntity;
import ru.liga.mappers.OrderItemMapper;
import ru.liga.repository.OrderItemsRepository;

import java.math.BigDecimal;

@Service
public class OrderItemServices {
    @Autowired
    OrderItemsRepository orderItemsRepository;
    @Autowired
    OrderItemMapper orderItemMapper;


    //Метод сохраняет заказ клиента
    public void saveOrderItem (MenuItemsOrderDto menuItemsOrder){

       OrderItemsEntity orderItemsEntity = orderItemMapper.dtoToEntity(menuItemsOrder);
        orderItemsRepository.save(orderItemsEntity);
    }

    //находит заказ клиентов по Id
    public MenuItemsOrderDto getOrderItemMenuId (long id){

        MenuItemsOrderDto menuItemsOrderDto = orderItemMapper.entityToDto(orderItemsRepository.findOrderItemsById(id));

        return menuItemsOrderDto;
    }
    //находит заказ клиента по цене
    public MenuItemsOrderDto getOrderItemMenuPrice (BigDecimal price){

        MenuItemsOrderDto menuItemsOrderDto = orderItemMapper.entityToDto(orderItemsRepository.findOrderItemsByPrice(price));
        return menuItemsOrderDto;
    }
    //удаление заказа клиента
    public void deleteOrderItem (long id){

        orderItemsRepository.deleteOrderItemsById(id);
    }




}
