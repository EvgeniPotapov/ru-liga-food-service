package ru.liga.kitchenController;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.rabbit.RabbitMqConfig;
import ru.liga.rabbit.UpdateStatusMessage;
import ru.liga.services.OrderServices;


import java.util.UUID;

@RestController
public class KitchenController {

    @Autowired
    OrderServices orderServices;
    @Autowired
    private RabbitTemplate template;

    //Контроллеры для изменения статуса заказа

    @PutMapping("/kitchen/{id}/accept")
    public void updateOrderStatusAccept (@PathVariable UUID id){
        String status = "accept";
        orderServices.updateOrderStatus(id, status );

        UpdateStatusMessage message = new UpdateStatusMessage(id,"статус изменён на accept ");
        template.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTINGKEY,message);
    }
    @PutMapping("/kitchen/{id}/decline")
    public void updateOrderStatusDecline (@PathVariable UUID id){
        String status = "decline";
        orderServices.updateOrderStatus(id, status );

        UpdateStatusMessage message = new UpdateStatusMessage(id,"статус изменён на decline ");
        template.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTINGKEY,message);
    }
    @PutMapping("/kitchen/{id}/ready")
    public void updateOrderStatusReady  (@PathVariable UUID id){
        String status = "ready";
        orderServices.updateOrderStatus(id, status );

        UpdateStatusMessage message = new UpdateStatusMessage(id,"статус изменён на ready ");
        template.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTINGKEY,message);

        UpdateStatusMessage messageReady = new UpdateStatusMessage(id,"заказ готов к доставке");
        template.convertAndSend("javaexchangeDelivery","javarutingkeyDelivery",messageReady);
    }

}
