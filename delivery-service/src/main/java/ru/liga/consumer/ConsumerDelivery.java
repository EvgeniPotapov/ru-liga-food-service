package ru.liga.consumer;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerDelivery {

    @SneakyThrows
    @RabbitListener(queues = "javaqueue")
    public void processMyQueue(String message) {

        String messageModel = message;
        log.info("Received from javaqueue : " +  messageModel);
        log.info("Работа в it");
    }

    @SneakyThrows
    @RabbitListener(queues = "myTopicQueue1")
    public void processMyTopicQueue(String message) {

        String messageModel = message;
        log.info("Received from myTopicQueue1 : " +  messageModel);
        log.info("Работа не в it");
    }
}
