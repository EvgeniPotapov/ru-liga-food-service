package ru.liga.orderController;


import org.springframework.web.bind.annotation.*;
import ru.liga.dto.Menu_itemsDto;
import ru.liga.orderDto.ItemsDto;
import ru.liga.orderDto.RestoranNameDto;
import ru.liga.orderDto.CreatNewOrderDto;
import ru.liga.orderDto.OrderDto;

@RestController
public class OrderController {

    @GetMapping("/order")
    public OrderDto getOrder (){

        OrderDto requestOrderDto = new OrderDto();
       requestOrderDto.setItems(new ItemsDto());
       requestOrderDto.setRestaurant(new RestoranNameDto());

        return requestOrderDto ;
    }
        @GetMapping("orders/{id}")
        public OrderDto getOrderById (@PathVariable("id") long id){

               OrderDto orderDto = new OrderDto();
               orderDto.setId(1);
               orderDto.setItems(new ItemsDto());
               orderDto.setTimestamp(30);
               orderDto.setRestaurant(new RestoranNameDto());

            return orderDto ;
        }

    @PostMapping("/order")
    public CreatNewOrderDto create (@RequestParam("restaurant_id") long restaurant_id, Menu_itemsDto menu_itemsDto){

            CreatNewOrderDto creatNewOrderDto = new CreatNewOrderDto();

        return creatNewOrderDto ;
    }

}
