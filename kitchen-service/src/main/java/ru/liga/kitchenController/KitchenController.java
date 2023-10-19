package ru.liga.kitchenController;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/orderes/{id}")
    public RestauranMenuItemsEntity orerInfo(@PathVariable("id") long id){

        RestauranMenuItemsEntity orderItemsEntity = restauranMenuItemsRepository.findRestauranMenuItemsById(id);


        return orderItemsEntity ;
    }

}
