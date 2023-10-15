package ru.liga.orderController;


import org.springframework.web.bind.annotation.*;
import ru.liga.dto.RequestMenu_itemsDto;
import ru.liga.dto.ResponseItemsDto;
import ru.liga.dto.ResponseRestoranNameDto;
import ru.liga.orderDto.ResponseCreatNewOrderDto;
import ru.liga.orderDto.ResponseOrderDto;

@RestController
public class OrderController {

    @GetMapping("/order")
    @ResponseBody
    public ResponseOrderDto getOrder (){

        ResponseOrderDto requestOrderDto = new ResponseOrderDto();
       requestOrderDto.setItems(new ResponseItemsDto());
       requestOrderDto.setRestaurant(new ResponseRestoranNameDto());

        return requestOrderDto ;
    }
        @GetMapping("orders/{id}")
        @ResponseBody
        public ResponseOrderDto getOrderById (@PathVariable("id") long id){

               ResponseOrderDto requestOrderDto = new ResponseOrderDto();
               requestOrderDto.setId(1);
               requestOrderDto.setItems(new ResponseItemsDto());
               requestOrderDto.setTimestamp(30);
               requestOrderDto.setRestaurant(new ResponseRestoranNameDto());

            return requestOrderDto ;
        }

    @PostMapping("/order")
    @ResponseBody
    public ResponseCreatNewOrderDto create (@PathVariable("id") long id, @PathVariable("menu_items") RequestMenu_itemsDto requestMenu_items){

            ResponseCreatNewOrderDto responseCreatNewOrderDto = new ResponseCreatNewOrderDto();

        return responseCreatNewOrderDto ;
    }

}
