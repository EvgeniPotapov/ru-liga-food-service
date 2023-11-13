package ru.liga.services;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.entities.OrderEntity;
import ru.liga.mappers.OrderMapper;
import ru.liga.orderDto.OrderDto;
import ru.liga.rabbitMq.CustomMessage;
import ru.liga.repository.OrdersRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServices {

    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    private RabbitTemplate template;

    ///////////////////////////метод сохраняющия звказ в базу данных//////////////////////////////
    public void postOrder (OrderDto orderDto){

        OrderEntity orderEntity = orderMapper.dtoToEntity(orderDto);
        orderEntity.setStatus("на модерации");
        orderEntity.setTimeStamp(new Date());
        ordersRepository.save(orderEntity);

        ///////////////////////отправка сообщения в kitchen-service/////////////////////////////////

        CustomMessage customMessage = new CustomMessage(orderEntity.getId(), "Доступен новый заказ");
        template.convertAndSend("javaexchangeOrder", "javarutingkeyOrder", customMessage);

    }
    //////////////////////////////Метод выдает заказ по id//////////////////////////////////////////////
    public OrderDto getOrderById(UUID id){

        OrderEntity orderEntity = ordersRepository.findOrdersById(id);

        OrderDto orderDto = orderMapper.entityToDto(orderEntity);

        return orderDto;
    }

    ///////////////////////////////метод изменения статуса заказа//////////////////////////////////
    public void updateOrderById(UUID id,String status){

        ordersRepository.updateStatusOrder(id,status);

    }
    ///////////////////////////////////получение списска всех заказов//////////////////////////////////////
    public List<OrderDto> getOrders (){

        List<OrderDto> orderDto = new ArrayList<>();

        List<OrderEntity> orderEntity = ordersRepository.findAll();

        for (OrderEntity entity:orderEntity){
            orderDto.add(orderMapper.entityToDto(entity));
        }
        return orderDto;
    }
}
