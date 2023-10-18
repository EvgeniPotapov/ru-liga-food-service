package ru.liga.kitchenController;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.dto.Menu_itemsDto;
import ru.liga.dto.OrderItemDto;
import ru.liga.dto.RestauranGetStatusGetIdDto;
import ru.liga.entities.OrderItemsEntity;
import ru.liga.entities.RestauranMenuItemsEntity;
import ru.liga.entities.RestaurantEntity;
import ru.liga.repository.OrderItemsRepository;
import ru.liga.repository.RestauranMenuItemsRepository;
import ru.liga.repository.RestauranRepository;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class KitchenController {

    @Autowired
    RestauranRepository restauranRepository;
    @Autowired
    RestauranMenuItemsRepository restauranMenuItemsRepository;
    @Autowired
    OrderItemsRepository orderItemsRepository;

    @GetMapping("/status/{status}")
    public RestaurantEntity restaurantByStatus(@PathVariable String status){
        RestaurantEntity restaurantSt = restauranRepository.findRestaurantByStatus(status);

        return restaurantSt ;
    }

    @GetMapping("/id/{id}")
    public RestaurantEntity restaurantById(@PathVariable("id") Long id){

      RestaurantEntity restaurant = restauranRepository.findRestaurantById(id);


        return restaurant ;
    }







}
