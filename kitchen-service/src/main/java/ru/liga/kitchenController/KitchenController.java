package ru.liga.kitchenController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.dto.MenuItemsOrderDto;
import ru.liga.dto.Menu_itemsDto;
import ru.liga.dto.OrderItemDto;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.entities.OrderItemsEntity;
import ru.liga.entities.RestauranMenuItemsEntity;
import ru.liga.entities.RestaurantEntity;
import ru.liga.repository.OrderItemsRepository;
import ru.liga.repository.RestauranMenuItemsRepository;
import ru.liga.repository.RestauranRepository;
import ru.liga.services.OrderItemServices;
import ru.liga.services.RestaurantItemServices;

import java.math.BigDecimal;
import java.sql.DataTruncation;

@RestController
public class KitchenController {

    @Autowired
    RestaurantItemServices restaurantItemServices;
    @Autowired
    OrderItemServices orderItemServices;


    @GetMapping("/order/{status}")
    public OrderItemDto orerInfo(@PathVariable("status") String status){

       OrderItemDto orderItemDto = new OrderItemDto();
       orderItemDto.setMenu_items(new Menu_itemsDto());


        return orderItemDto ;
    }

    //Добавление заказа клиента
    @PostMapping("/order/save")
    public void saveOrderItem (@RequestBody MenuItemsOrderDto menuItemsOrderDto){

        orderItemServices.saveOrderItem(menuItemsOrderDto);
    }
    //Получение заказа по Id
    @GetMapping("/getOrderItem/{id}")
    public MenuItemsOrderDto getOrderItem (@PathVariable long id){

        return orderItemServices.getOrderItemMenu(id);
    }

    //метод ля изменения поля цены
    @PutMapping("menu/update/{id}/{price}")
    public void updateMenuRestauran (@PathVariable long id,@PathVariable BigDecimal price){

        restaurantItemServices.updatePriceMenu(id, price);
    }
    //Добавление нового меню
    @PostMapping("/menu/save")
    public void saveMenuRestaurant (@RequestBody RestauranMenuItemsDto restauranMenuItemsDto){

        restaurantItemServices.saveRestauranMenu(restauranMenuItemsDto);
    }
    //Удаление меню по id
    @DeleteMapping("/menu/delete/{id}")
    public void deleteRestauranMenu (@PathVariable long id){

        restaurantItemServices.deleteRestauranMenu(id);
    }

    //получить меню по id
    @GetMapping("/getmenu/{id}")
    public RestauranMenuItemsDto getRestauranMenu (@PathVariable long id){

       return restaurantItemServices.getRestauranMenuId(id);


    }


}
