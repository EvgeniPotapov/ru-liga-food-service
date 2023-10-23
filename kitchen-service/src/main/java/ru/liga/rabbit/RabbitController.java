package ru.liga.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class RabbitController {


    private RabbitTemplate template;

    public RabbitController(RabbitTemplate template) {
        this.template = template;
    }

    //Отправление сообщения в сервис доставки
    @PostMapping("/message")
    public String sendMessageToRabbit(@RequestBody CustomMessage customMessage) {

        template.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTINGKEY,customMessage);

        return "Message";
    }
}
