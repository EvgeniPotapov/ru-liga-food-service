package ru.liga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.dao.OrderDao;
import ru.liga.models.Order;


@RestController
@RequestMapping("/kitchen")
public class KitchenController {
    private final OrderDao orderDao;

    @Autowired
    public KitchenController(OrderDao orderDao1) {
        this.orderDao = orderDao1;

    }

    @GetMapping("/{id}")
    public Order searchOrder(@PathVariable("id") long id){

        return orderDao.searchOrderById(id);
    }

    @PatchMapping("{id}")
    public String setOrder (@PathVariable("id") long id, @PathVariable("status") String status){
        orderDao.setOrdersById(id, status);
        return "Объект изменён";

    }
}
