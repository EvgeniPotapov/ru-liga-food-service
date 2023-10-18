package ru.liga.orderController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.Menu_itemsDto;
import ru.liga.entities.CustomersEntity;
import ru.liga.entities.OrdersEntity;
import ru.liga.orderDto.*;
import ru.liga.repository.CustomersRepository;
import ru.liga.repository.OrdersRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

@Autowired
OrdersRepository ordersRepository;
@Autowired
CustomersRepository customersRepository;

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


}
