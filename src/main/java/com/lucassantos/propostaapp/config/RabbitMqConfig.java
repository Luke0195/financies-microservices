package com.lucassantos.propostaapp.config;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// O spring será responsável por gerenciar essa classe
@Configuration
public class RabbitMqConfig {
    // proposta-pendente.ms-notificacao
    // proposta-concluida.ms-proposta
    // proposta-concluida.ms-notificacao
    @Bean
    public Queue criarFilaPropostaPendenteMsAnaliseCredito(){
        return QueueBuilder.durable("proposta-pendente.ms-analise-credito").build();
    }
    /*
    private ConnectionFactory connectionFactory;

    public RabbitMqConfig(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }
     */
    @Bean
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> iniciarRabbitAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }
}
