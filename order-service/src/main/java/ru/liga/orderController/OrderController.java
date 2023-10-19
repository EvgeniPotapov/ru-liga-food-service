package ru.liga.orderController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.entities.OrdersEntity;
import ru.liga.model.Menu_Items;
import ru.liga.model.RestoranName;
import ru.liga.orderDto.*;
import ru.liga.repository.CustomersRepository;
import ru.liga.repository.OrdersRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("/orders")
    public List<OrderDto> getOrder (){

        List <OrderDto> orders= new ArrayList<>();

        OrderDto requestOrderDto = new OrderDto();
       requestOrderDto.setItems(new Menu_Items());
       requestOrderDto.setRestaurant(new RestoranName());
       orders.add(requestOrderDto);

        return orders ;
    }
        @GetMapping("/order/{id}")
        public OrderDto getOrderById (@PathVariable("id") long id){

               OrderDto orderDto = new OrderDto();
               orderDto.setId(id);
               orderDto.setItems(new Menu_Items());
               orderDto.setTimestamp(30);
               orderDto.setRestaurant(new RestoranName());

            return orderDto ;
        }

    @PostMapping("/order")
    public CreatNewOrderDto create (@PathVariable("id") long id, Menu_restoran menu_restoran){

        return new CreatNewOrderDto() ;
    }

    @GetMapping("/or/{id}")
    public OrdersEntity ById (@PathVariable("id") long id){

      OrdersEntity customersEntity =  ordersRepository.findOrdersById(id);

        return customersEntity ;
    }

}
