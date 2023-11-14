package ru.liga.kitchenController;

import org.apache.ibatis.javassist.NotFoundException;
import org.springdoc.api.ErrorMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.rabbit.CustomMessage;
import ru.liga.rabbit.RabbitMqConfig;
import ru.liga.services.OrderServices;
import ru.liga.services.RestaurantServices;


import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/kitchen")
public class KitchenController {

    @Autowired
    OrderServices orderServices;
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private RestaurantServices restaurantServices;

    ////////////////////////////Контроллеры для изменения статуса заказа////////////////////////////////////////

    @PutMapping("/{id}/accept")
    public void updateOrderStatusAccept (@PathVariable UUID id){
        String status = "accept";
        orderServices.updateOrderStatus(id, status );

        //отправка сообщения об изменении статуса в order-service
        CustomMessage message = new CustomMessage(id,"статус изменён на accept ");
        template.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTINGKEY,message);
    }
    @PutMapping("/{id}/decline")
    public void updateOrderStatusDecline (@PathVariable UUID id){
        String status = "decline";
        orderServices.updateOrderStatus(id, status );

        //отправка сообщения об изменении статуса в order-service
        CustomMessage message = new CustomMessage(id,"статус изменён на decline ");
        template.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTINGKEY,message);
    }
    @PutMapping("/{id}/ready")
    public void updateOrderStatusReady  (@PathVariable UUID id){
        String status = "ready";
        orderServices.updateOrderStatus(id, status );

        //отправка сообщения об изменении статуса в order-service
        CustomMessage message = new CustomMessage(id,"статус изменён на ready ");
        template.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTINGKEY,message);

        //отправка сообщения о готовности заказа к доставке в delivery-service
        CustomMessage messageReady = new CustomMessage(id,"заказ готов к доставке");
        template.convertAndSend("javaexchangeDelivery","javarutingkeyDelivery",messageReady);
    }

    ///////////////////////////////////метод сохранения ресторана в базу данных/////////////////////////////////////////
    @PostMapping("/restaurant/save")
    public void saveRestaurantAndMenu(@RequestBody RestaurantDto restaurantDto){

        restaurantServices.saveRestaurant(restaurantDto);
    }

    ///////////////////////////////////метод сохранения меню ресторана по названию ресторана////////////////////////////
    @PostMapping("/menu/save/{nameRestaurant}")
    public void saveMenuRestaurant(@PathVariable String nameRestaurant,
                                   @RequestBody RestauranMenuItemsDto restauranMenuItemsDto){

        restaurantServices.saveMenuRestaurant(nameRestaurant,restauranMenuItemsDto);
    }

    /////////////////Изменение стоимости блюда по названию ресторана и названию блюда///////////////////////////////////
    @PutMapping("/menu/update/{nameRestaurant}/{nameItems}/{price}")
    public void updatePrice (@PathVariable String nameRestaurant,
                             @PathVariable String nameItems,
                             @PathVariable BigDecimal price){

        restaurantServices.updatePriceByNameItems(nameRestaurant,nameItems,price);

    }


}
