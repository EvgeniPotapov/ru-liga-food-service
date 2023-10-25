package ru.liga.kitchenController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.dto.*;
import ru.liga.services.OrderItemServices;
import ru.liga.services.RestaurantItemServices;
import ru.liga.services.RestaurantServices;

import java.math.BigDecimal;

@RestController
public class KitchenController {

    @Autowired
    private RestaurantItemServices restaurantItemServices;
    @Autowired
    private OrderItemServices orderItemServices;
    @Autowired
    private RestaurantServices restaurantServices;

    //Получение заказа по статусу
    @GetMapping("/orders")
    public OrderItemDto orderInfo(@RequestParam ("status") String status){

       OrderItemDto orderItemDto = new OrderItemDto();
       orderItemDto.setMenuItems(new MenuItems());


        return orderItemDto ;
    }
    ////////////////////////////////////////////
    ///////////OrderItem///////////////////////

    //Добавление заказа клиента
    @PostMapping("/orderItem/save")
    public void saveOrderItem (@RequestBody MenuItemsOrderDto menuItemsOrderDto){

        orderItemServices.saveOrderItem(menuItemsOrderDto);
    }
    //Получение заказа клиента по Id
    @GetMapping("/orderItem/{id}")
    public MenuItemsOrderDto getOrderItemId (@PathVariable long id){

        return orderItemServices.getOrderItemMenuId(id);
    }
    //получение заказа клиента по цене
    @GetMapping("/orderItem/price/{price}")
    public  MenuItemsOrderDto getOrderItemPrice(@PathVariable BigDecimal price){

        return orderItemServices.getOrderItemMenuPrice(price);
    }
    //удаление заказа клиента
    @DeleteMapping("orderItem/delete/{id}")
    public void deleteOrderItem(@PathVariable long id ){

        orderItemServices.deleteOrderItem(id);
    }
    ////////////////////////////////////////////////
    ///////////////RestaurantMenuItem//////////////

    //метод ля изменения поля цены
    @PutMapping("menu/update/{id}/{price}")
    public void updateMenuRestauran (@PathVariable long id,@PathVariable BigDecimal price){

        restaurantItemServices.updatePriceMenu(id, price);
    }
    //Добавление нового меню
    @PostMapping("/menu/save")
    public void saveRestaurantMenu (@RequestBody RestauranMenuItemsDto restauranMenuItemsDto){

        restaurantItemServices.saveRestauranMenu(restauranMenuItemsDto);
    }
    //Удаление меню по id
    @DeleteMapping("/menu/delete/{id}")
    public void deleteRestauranMenu (@PathVariable long id){

        restaurantItemServices.deleteRestauranMenu(id);
    }

    //получить меню по id
    @GetMapping("/menu/{id}")
    public RestauranMenuItemsDto getRestauranMenuId (@PathVariable long id){

       return restaurantItemServices.getRestauranMenuId(id);
    }

    //получение меню по названию
    @GetMapping("/menu/name/{name}")
    public RestauranMenuItemsDto getRestauranMenuName (@PathVariable String name){
        return restaurantItemServices.getRestauranMenuName(name);
    }

    //////////////////////////////////////
    ///////////Restaurant////////////////

    //получение ресторана по id
    @GetMapping("/restauran/{id}")
    public RestaurantDto getRestauranId (@PathVariable long id){

        return restaurantServices.getRestaurantId(id);
    }

    //получение ресторана по статусу
    @GetMapping("/restauran/status/{status}")
    public RestaurantDto getRestauranStatus (@PathVariable String status){

        return restaurantServices.getRestaurantStatus(status);
    }







}
