package ru.liga.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void listener( CustomMessage message){

        System.out.println(message);
    }

}
