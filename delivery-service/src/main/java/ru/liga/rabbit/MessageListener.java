package ru.liga.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class MessageListener {

    //Принимаем сообщение из сервиса кухни
    @RabbitListener(queues ="javaqueueDelivery")
    public void listener( UpdateStatusMessage message){

        System.out.println(message);
    }

}
