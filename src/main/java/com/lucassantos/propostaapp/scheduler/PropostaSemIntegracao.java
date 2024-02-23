package com.lucassantos.propostaapp.scheduler;

import com.lucassantos.propostaapp.entities.Proposta;
import com.lucassantos.propostaapp.repositories.PropostaRepository;
import com.lucassantos.propostaapp.services.impl.NotificacaoRabbitServiceImpl;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class PropostaSemIntegracao {
    private final PropostaRepository propostaRepository;
    private final NotificacaoRabbitServiceImpl notificacaoService;
    private final  String exchangeName;
    private final Logger logger = LoggerFactory.getLogger(PropostaSemIntegracao.class);

    public PropostaSemIntegracao(PropostaRepository propostaRepository,
                                 NotificacaoRabbitServiceImpl notificacaoService
            , @Value("${rabbit.propostapendente.exchange}") String exchangeName) {
        this.propostaRepository = propostaRepository;
        this.notificacaoService = notificacaoService;
        this.exchangeName = exchangeName;
    }
    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.MICROSECONDS)
    public void buscarPropostaSemIntegracao(){
        propostaRepository.findAllByIntegradaIsFalse().forEach( proposta -> {
            try{
                notificacaoService.notificar(proposta, exchangeName);
                atualizarProposta(proposta);
            }catch(RuntimeException e){
                logger.error(e.getMessage());
            }
        });
    }

    private void atualizarProposta(Proposta proposta){
        proposta.setIntegrada(true);
        propostaRepository.save(proposta);

    }


}
