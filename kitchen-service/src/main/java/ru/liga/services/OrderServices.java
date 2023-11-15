package ru.liga.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.repository.OrderRepository;

import java.util.UUID;

@Service
@Slf4j
public class OrderServices {
    @Autowired
    OrderRepository orderRepository;

    public void updateOrderStatus (UUID id,String status){

      orderRepository.updateStatusOrder(id, status);
    }

}
