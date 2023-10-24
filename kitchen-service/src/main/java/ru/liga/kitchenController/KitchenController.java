package ru.liga.kitchenController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.dto.MenuItemsOrderDto;
import ru.liga.dto.MenuItems;
import ru.liga.dto.OrderItemDto;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.services.OrderItemServices;
import ru.liga.services.RestaurantItemServices;

import java.math.BigDecimal;

@RestController
public class KitchenController {

    @Autowired
    private RestaurantItemServices restaurantItemServices;
    @Autowired
    private OrderItemServices orderItemServices;

    //Получение заказа по статусу
    @GetMapping("/ordersInf")
    public OrderItemDto orderInfo(@RequestBody String status){

       OrderItemDto orderItemDto = new OrderItemDto();
       orderItemDto.setMenuItems(new MenuItems());


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
