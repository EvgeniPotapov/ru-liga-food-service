package ru.liga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.entities.OrderEntity;
import ru.liga.mappers.OrderMapper;
import ru.liga.repository.OrderRepository;

import java.util.UUID;

@Service
public class OrderServices {
    @Autowired
    OrderRepository orderRepository;

    public void updateOrderStatus (UUID id,String status){

      orderRepository.updateStatusOrder(id, status);
    }

}
