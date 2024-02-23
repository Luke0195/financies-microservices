package com.lucassantos.propostaapp.services.impl;

import com.lucassantos.propostaapp.dtos.proposta.PropostaRequestDto;
import com.lucassantos.propostaapp.dtos.proposta.PropostaResponseDto;
import com.lucassantos.propostaapp.entities.Proposta;
import com.lucassantos.propostaapp.mapper.PropostaMapper;
import com.lucassantos.propostaapp.repositories.PropostaRepository;
import com.lucassantos.propostaapp.services.PropostaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropostaServiceImpl implements PropostaService {

    private final PropostaRepository propostaRepository;
    private final NotificacaoRabbitServiceImpl notificacaoRabbitServiceImpl;
    private final String exchangeName;

    @Autowired
    public PropostaServiceImpl(PropostaRepository propostaRepository, NotificacaoRabbitServiceImpl notificacaoRabbitServiceImpl,
                               @Value("${rabbit.propostapendente.exchange}") String exchangeName){
        this.notificacaoRabbitServiceImpl = notificacaoRabbitServiceImpl;
        this.propostaRepository = propostaRepository;
        this.exchangeName = exchangeName;
    }

    public PropostaResponseDto create(PropostaRequestDto propostaRequestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(propostaRequestDto);
        this.propostaRepository.save(proposta);
        notificarRabbitMq(proposta);
        return  PropostaMapper.INSTANCE.convertEntityToPropostaResponseDto(proposta);
    }

    private void notificarRabbitMq(Proposta proposta){
        try{
            notificacaoRabbitServiceImpl.notificar(proposta, exchangeName);
        }catch(RuntimeException ex){
            proposta.setIntegrada(false);
            propostaRepository.save(proposta);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public Page<PropostaResponseDto> findAllPaged(Pageable pageable) {
        Page<Proposta> propostas = propostaRepository.findAll(pageable);

        return propostas.map(PropostaMapper.INSTANCE::convertEntityToPropostaResponseDto);
    }
}
