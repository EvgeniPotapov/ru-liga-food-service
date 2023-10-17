package ru.liga.orderController;


import org.springframework.web.bind.annotation.*;
import ru.liga.dto.Menu_itemsDto;
import ru.liga.orderDto.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {



    @GetMapping("/orders")
    public List<OrderDto> getOrder (){

        List <OrderDto> orders= new ArrayList<>();

        OrderDto requestOrderDto = new OrderDto();
       requestOrderDto.setItems(new Menu_Items());
       requestOrderDto.setRestaurant(new RestoranName());
       orders.add(requestOrderDto);

        return orders ;
    }
        @GetMapping("/orders/{id}")
        public OrderDto getOrderById (@PathVariable("id") long id){

               OrderDto orderDto = new OrderDto();
               orderDto.setId(id);
               orderDto.setItems(new Menu_Items());
               orderDto.setTimestamp(30);
               orderDto.setRestaurant(new RestoranName());

            return orderDto ;
        }

    @PostMapping("/order")
    public CreatNewOrderDto create (@RequestBody Menu_restoran menu_restoran){

        return new CreatNewOrderDto() ;
    }

}
