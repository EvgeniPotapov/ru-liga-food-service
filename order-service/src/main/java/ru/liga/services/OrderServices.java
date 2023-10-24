package ru.liga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.entities.CustomersEntity;
import ru.liga.entities.OrdersEntity;
import ru.liga.mappers.OrderMapper;
import ru.liga.orderDto.CustomerDto;
import ru.liga.orderDto.OrderDto;
import ru.liga.repository.OrdersRepository;

@Service
public class OrderServices {

    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrderMapper orderMapper;

    public OrderDto getOrderId (long id){

        OrdersEntity ordersEntity = ordersRepository.findOrdersById(id);
        OrderDto orderDto = orderMapper.entityToDto(ordersEntity);

        return orderDto;
    }

    public OrderDto detOrderStatus(String status){

        OrdersEntity ordersEntity = ordersRepository.findOrdersByStatus(status);
        OrderDto orderDto = orderMapper.entityToDto(ordersEntity);
        return orderDto;
    }
}
