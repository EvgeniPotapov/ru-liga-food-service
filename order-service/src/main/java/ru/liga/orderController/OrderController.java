package ru.liga.orderController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.orderDto.MenuItems;
import ru.liga.orderDto.RestoranName;
import ru.liga.orderDto.*;
import ru.liga.services.CustomerServices;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    CustomerServices customerServices;

    //получение списка всех заказов
    @GetMapping("/orders")
    public List<OrderDto> getOrder (){

        List <OrderDto> orders= new ArrayList<>();

        OrderDto requestOrderDto = new OrderDto();
       requestOrderDto.setItems(new MenuItems());
       requestOrderDto.setRestaurant(new RestoranName());
       orders.add(requestOrderDto);

        return orders ;
    }

        //получение заказа по Id
        @GetMapping("/order/{id}")
        public OrderDto getOrderById (@PathVariable("id") long id){

               OrderDto orderDto = new OrderDto();
               orderDto.setId(id);
               orderDto.setItems(new MenuItems());
               orderDto.setTimestamp(30);
               orderDto.setRestaurant(new RestoranName());

            return orderDto ;
        }

     //оплата заказа
    @PostMapping("/order")
    public PaymentToOrderDto paymentOrder (@PathVariable("id") long id, @RequestBody MenuRestoran menuRestoran){

        return new PaymentToOrderDto() ;
    }

    //получение клиента по Id
    @GetMapping("/customer/{id}")
    public CustomerDto ById (@PathVariable long id){

        return customerServices.getCustomerId(id);
    }
 //пробный push


}
