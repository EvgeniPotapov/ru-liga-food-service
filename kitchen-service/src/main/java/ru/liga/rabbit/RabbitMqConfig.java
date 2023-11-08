package ru.liga.rabbit;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String QUEUE="javaqueueKithen";
    public static final String EXCHANGE="javaexchangeKithen";
    public static final String ROUTINGKEY="javarutingkeyKithen";

    //Создание очереди
    @Bean
    public Queue queue(){

        return new Queue(QUEUE);
    }

    //Создание обменника
    @Bean
    public TopicExchange exchange (){

        return new TopicExchange(EXCHANGE);
    }

    //Сщединение очереди и обменника
    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTINGKEY);
    }

    //конвертер сообщений
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate =new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(messageConverter());

        return rabbitTemplate;
    }
}
