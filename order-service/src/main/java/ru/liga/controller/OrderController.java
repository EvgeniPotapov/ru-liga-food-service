package ru.liga.controller;

import java.util.List;
import java.util.UUID;


import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springdoc.api.ErrorMessage;
import org.springframework.web.bind.annotation.*;
import ru.liga.orderDto.OrderDto;
import ru.liga.services.OrderServices;


@RestController
public class OrderController {
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private OrderServices orderServices;

    ////////////////////////////////Добавление заказа в БД/////////////////////////////////////

    @PostMapping("/orders")
    public void postOrder(@RequestBody OrderDto orderDto) {

        orderServices.postOrder(orderDto);
    }

    ////////////////////////////////получение заказа по id/////////////////////////////////////

    @GetMapping("/orders/{id}")
    public OrderDto getOrderById(@PathVariable("id") UUID id) {
        return this.orderServices.getOrderById(id);
    }

    ////////////////////////////////изменение статуса заказа по id/////////////////////////////////////

    @PutMapping("/orders/{id}")
    public void updateOrderById(@PathVariable("id") UUID id, @RequestParam("status") String status) {
        orderServices.updateOrderById(id, status);
    }

    ////////////////////////////////получение списка всех заказов/////////////////////////////////////

    @GetMapping({"/orders"})
    public List<OrderDto> getOrderBy() {
        return orderServices.getOrders();
    }

    ///////////////////////////////Ответ когда метод getOrderById равен null /////////////////////////////////////

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(NotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(exception.getMessage()));
    }

}