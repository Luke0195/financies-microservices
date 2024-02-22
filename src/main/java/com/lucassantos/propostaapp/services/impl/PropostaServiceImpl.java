package com.lucassantos.propostaapp.services.impl;

import com.lucassantos.propostaapp.dtos.proposta.PropostaRequestDto;
import com.lucassantos.propostaapp.dtos.proposta.PropostaResponseDto;
import com.lucassantos.propostaapp.entities.Proposta;
import com.lucassantos.propostaapp.mapper.PropostaMapper;
import com.lucassantos.propostaapp.repositories.PropostaRepository;
import com.lucassantos.propostaapp.repositories.UsuarioRepository;
import com.lucassantos.propostaapp.services.PropostaService;


import com.lucassantos.propostaapp.services.exceptions.ResourceNotExistsException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PropostaServiceImpl implements PropostaService {

    private final PropostaRepository propostaRepository;
    private final NotificacaoServiceImpl notificacaoServiceImpl;
    public PropostaResponseDto create(PropostaRequestDto propostaRequestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(propostaRequestDto);
        this.propostaRepository.save(proposta);
        PropostaResponseDto responseDto = PropostaMapper.INSTANCE.convertEntityToPropostaResponseDto(proposta);
        notificacaoServiceImpl.notificar(responseDto, "proposta-pendente.ex");
        return  responseDto;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PropostaResponseDto> findAllPaged(Pageable pageable) {
        Page<Proposta> propostas = propostaRepository.findAll(pageable);

        return propostas.map(PropostaMapper.INSTANCE::convertEntityToPropostaResponseDto);
    }
}
