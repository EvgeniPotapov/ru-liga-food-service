package ru.liga.kitchenController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.dto.Menu_itemsDto;
import ru.liga.dto.OrderItemDto;
import ru.liga.entities.OrderItemsEntity;
import ru.liga.entities.RestauranMenuItemsEntity;
import ru.liga.entities.RestaurantEntity;
import ru.liga.repository.OrderItemsRepository;
import ru.liga.repository.RestauranMenuItemsRepository;
import ru.liga.repository.RestauranRepository;

import java.math.BigDecimal;
import java.sql.DataTruncation;

@RestController
public class KitchenController {
    @Autowired
    OrderItemsRepository orderItemsRepository;
    @Autowired
    RestauranRepository restauranRepository;
    @Autowired
    RestauranMenuItemsRepository restauranMenuItemsRepository;


    @GetMapping("/order/{status}")
    public OrderItemDto orerInfo(@PathVariable("status") String status){

       OrderItemDto orderItemDto = new OrderItemDto();
       orderItemDto.setMenu_items(new Menu_itemsDto());


        return orderItemDto ;
    }



    @PostMapping("/menu/save")
    public void saveMenuRestaurant (@RequestBody RestauranMenuItemsEntity restauranMenuItemsEntity){

        restauranMenuItemsRepository.save(restauranMenuItemsEntity);
    }


    @PostMapping("/orderes/save")
    public void saveOrderItem (@RequestBody OrderItemsEntity orderItemsEntity){

        orderItemsRepository.save(orderItemsEntity);
    }

}
