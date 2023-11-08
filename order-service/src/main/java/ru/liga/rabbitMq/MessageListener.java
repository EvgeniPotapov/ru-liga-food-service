package ru.liga.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    //Принимаем сообщение из сервиса кухни
    @RabbitListener(queues = "javaqueueKithen")
    public void listener( UpdateStatusMessage message){

        System.out.println(message);
    }

}

