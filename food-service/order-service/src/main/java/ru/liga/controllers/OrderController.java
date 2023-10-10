package ru.liga.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.liga.dao.OrderDao;
import ru.liga.models.Order;


@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderDao orderDao;

    @Autowired
    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }


    //форма добавления нового заказа
    @GetMapping("/new")
    public String newOrder (@ModelAttribute("order") Order order){

        return "Форма создания нового заказа";
    }

    //добавление нового заказа в базу данных
    @PostMapping()
    public String createOrder(@ModelAttribute("order") Order order){

        orderDao.addOrder(order);
        return "Форма создания нового заказа";
    }
    //Поиск заказа по id
    @GetMapping("/{id}")
    public Order searchOrder(@PathVariable("id") long id){

        return orderDao.searchOrderById(id);
    }
    //изменение заказа по id
    @PatchMapping("{id}")
    public String setOrder (@PathVariable("id") long id, @PathVariable("status") String status){
        orderDao.setOrdersById(id, status);
        return "Объект изменён";

    }
    //Удаление заказа по id
    public String delitOrder (@PathVariable("id") long id){

        orderDao.delitOrderById(id);
        return "заказ удалён";

    }




}
