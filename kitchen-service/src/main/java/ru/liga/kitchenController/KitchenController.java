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

    @PostMapping("/orderes/{id}/{restaurantId}/{name}/{price}/{image}/{description}")
    public void saveMenuRestaurant (@PathVariable long id,@PathVariable long restaurantId,@PathVariable String name,
                                             @PathVariable double price,@PathVariable String image,@PathVariable String description,
                                             RestauranMenuItemsEntity restauranMenuItemsEntity){

        restauranMenuItemsRepository.save(restauranMenuItemsEntity);
    }

    @PostMapping("/orderes/{id}/{orderId}/{restaurantMenuItems}/{price}/{quantitu}")
    public void saveOrderItems (@PathVariable long id, @PathVariable long orderId, @PathVariable long restaurantMenuItems,
                                @PathVariable BigDecimal price, @PathVariable int quantitu, OrderItemsEntity orderItemsEntity){

        orderItemsRepository.save(orderItemsEntity);
    }

}
