package com.priya.app.config;

import org.springframework.amqp.core.DirectExchange;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;




@Configuration
public class RabbitMqConfigProducer {
    @Value("${rabbitmq.exchange.name}")
    String exchangeName;
    @Value("${rabbitmq.parkingStart.queue.name}")
    String parkingStartqueuename;
    @Value("${rabbitmq.parkingStart.routingkey.name}")
    String parkingStartRoutingKeyName;
    @Value("parking-end-request.out")
    String parkingEndRequestOut;
    @Value("parkingEnd.routingkey")
    String parkingEndRoutingKeyName;

//

    @Value("${rabbitmq.parkingStartResponse.queue.name}")
    String parkingStartResponsequeuename;
    @Value("${rabbitmq.parkingStartResponse.routingkey.name}")
    String parkingStartResponseRoutingKeyName;
    @Value("${rabbitmq.parkingEndResponse.queue.name}")
    String parkingEndResponsequeuename;
    @Value("${rabbitmq.parkingEndResponse.routingkey.name}")
    String parkingEndResponseRoutingKeyName;

    @Bean
    public Queue startResponseQueue() {
        return new Queue(parkingStartResponsequeuename, true);
    }

    @Bean
    public Queue endResponseQueue() {
        return new Queue(parkingEndResponsequeuename, true);
    }

    @Bean
    public Binding startResponseBinding(Queue startResponseQueue) {
        return BindingBuilder.bind(startResponseQueue).to(new DirectExchange(exchangeName))
                .with(parkingStartResponseRoutingKeyName);
    }

    @Bean
    public Binding endResponseBinding(Queue startResponseQueue) {
        return BindingBuilder.bind(startResponseQueue).to(new DirectExchange(exchangeName))
                .with(parkingEndResponseRoutingKeyName);
    }

    @Bean
    public Jackson2JsonMessageConverter consumerJsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public AmqpTemplate consumerAmqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(consumerJsonMessageConverter());
        return rabbitTemplate;
    }





    @Bean
public Queue parkingStartqueue() {
    return new Queue(parkingStartqueuename, true) {
    };

}
@Bean
public Queue parkingEndqueue() {
    return new Queue(parkingEndRequestOut, true) {};
}
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding parkingStartBinding(Queue parkingStartqueue, DirectExchange exchange) {
        return BindingBuilder.bind(parkingStartqueue).to(exchange).with(parkingStartRoutingKeyName);
    }
    @Bean
    public Binding parkingEndBinding(Queue parkingEndqueue, DirectExchange exchange) {
     return BindingBuilder.bind(parkingEndqueue).to(exchange).with(parkingEndRoutingKeyName);
    }
    @Bean
    public MessageConverter JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(JsonMessageConverter());
        return rabbitTemplate;
    }


    }





