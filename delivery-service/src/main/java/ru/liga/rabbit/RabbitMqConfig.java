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

    public static final String QUEUE="javaqueueDelivery";
    public static final String EXCHANGE="javaexchangeDelivery";
    public static final String ROUTINGKEY="javarutingkeyDelivery";

    //создание очереди
    @Bean
    public Queue queue(){

        return new Queue(QUEUE);
    }
    //создание exchange
    @Bean
    public TopicExchange exchange (){

        return new TopicExchange(EXCHANGE);
    }

    //создание соединения очереди и exchange
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
