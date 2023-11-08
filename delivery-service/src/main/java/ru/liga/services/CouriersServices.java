package ru.liga.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.OrderDto;
import ru.liga.entities.OrderEntity;
import ru.liga.mappers.CourierMappers;
import ru.liga.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class CouriersServices {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CourierMappers courierMappers;

    public List<OrderDto> getOrders (){

        List<OrderDto> orderDto = new ArrayList<>();

        List<OrderEntity> orderEntity = orderRepository.findAll();

        for (OrderEntity entity:orderEntity){
            orderDto.add(courierMappers.entityToDto(entity));
        }
        return orderDto;
    }

    //метод изменения статуса заказа
    public void updateOrderById(UUID id, String status){

        orderRepository.updateStatusOrder(id, status);

    }
}
