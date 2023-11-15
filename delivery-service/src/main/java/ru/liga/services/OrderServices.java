package ru.liga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderDto;
import ru.liga.entities.OrderEntity;
import ru.liga.mappers.OrderMapper;
import ru.liga.repository.CouriersRepository;
import ru.liga.repository.OrderRepository;

import java.util.UUID;
@Service
public class OrderServices {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;



    ////////////////////////////////////////////метод изменения статуса заказа/////////////////////////////////////////
    public void updateOrderById(UUID id, String status){

        orderRepository.updateStatusOrder(id, status);

    }

////////////////////////////////////////////Получение заказа по id////////////////////////////////////////////////////

    public OrderDto getOrder(UUID id){

        OrderDto orderDto = orderMapper.entityToDto(orderRepository.findOrderById(id));

        return orderDto;
    }
}
