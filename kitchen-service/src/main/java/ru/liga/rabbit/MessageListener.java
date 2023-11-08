package ru.liga.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    //Принимаем сообщение из сервиса order
    @RabbitListener(queues = "javaqueueOrder")
    public void listener( CustomMessage message){

        System.out.println(message);
    }

}
