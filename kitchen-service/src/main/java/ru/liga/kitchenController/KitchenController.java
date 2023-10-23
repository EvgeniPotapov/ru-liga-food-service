package ru.liga.kitchenController;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.dto.MenuItemsOrderDto;
import ru.liga.dto.Menu_itemsDto;
import ru.liga.dto.OrderItemDto;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.entities.CustomMessage;
import ru.liga.services.OrderItemServices;
import ru.liga.services.RestaurantItemServices;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@RestController
public class KitchenController {

    @Autowired
    private RestaurantItemServices restaurantItemServices;
    @Autowired
    private OrderItemServices orderItemServices;
    @Autowired
    private RabbitTemplate template;

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

    //Отправление сообщения в очередь
    @PostMapping("/message")
    public String sendMessageToRabbit(@RequestBody CustomMessage customMessage) {

        customMessage.setMassageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());
        template.convertAndSend("javaexchange","javarutingkey",customMessage);
        return "Message";
    }


}
