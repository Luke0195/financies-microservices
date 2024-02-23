package com.lucassantos.propostaapp.services.impl;


import com.lucassantos.propostaapp.entities.Proposta;
import com.lucassantos.propostaapp.services.NotificacaoService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificacaoRabbitServiceImpl implements NotificacaoService {

    private final RabbitTemplate rabbitTemplate; // O rabbitmq por padrão não possui configuração para se trabalhar com objetos.

    public void notificar(Proposta proposta, String exchange){
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }
}
