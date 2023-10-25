package ru.liga.kitchenController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.MenuItemsOrderDto;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.myBatis.OrderItemsMapper;
import ru.liga.myBatis.RestaurantMapper;
import ru.liga.myBatis.RestaurantMenuItemsMapper;

import java.math.BigDecimal;

@RestController
@RequestMapping("myBatis")
public class MyBatisController {
    @Autowired
    RestaurantMapper restaurantMapper;
    @Autowired
    RestaurantMenuItemsMapper restaurantMenuItemsMapper;
    @Autowired
    OrderItemsMapper orderItemsMapper;

    //////////////////////////////////////////////////
    ///////////////Restaurant////////////////////////

    @GetMapping("restauranId/{id}")
    RestaurantDto restaurantById (@PathVariable long id){
        return restaurantMapper.getRestaurantById(id);
    }

    @GetMapping("restauranAddress/{address}")
    RestaurantDto restaurantByAddress (@PathVariable String address){
        return restaurantMapper.getRestaurantByAddress(address);
    }

    ////////////////////////////////////////////////////
    ///////////////OrderItems//////////////////////////

    @GetMapping("orderItemId/{id}")
    MenuItemsOrderDto orderItemById (@PathVariable long id){
        return orderItemsMapper.getOrderItemById(id);
    }

    @GetMapping("orderItemPrice/{price}")
    MenuItemsOrderDto orderItemByPrice (@PathVariable BigDecimal price){
        return orderItemsMapper.getOrderItemByPrice(price);
    }

    /////////////////////////////////////////////////////
    ///////////////RestaurantMenuItems//////////////////

    @GetMapping("restaurantMenuId/{id}")
    RestauranMenuItemsDto restauranMenuItemById (@PathVariable long id){
        return restaurantMenuItemsMapper.getRestaurantById(id);
    }

    @GetMapping("restaurantMenuPrice/{price}")
    RestauranMenuItemsDto restauranMenuItemByPrice (@PathVariable BigDecimal price){
        return restaurantMenuItemsMapper.getRestaurantByPrice(price);
    }

}
