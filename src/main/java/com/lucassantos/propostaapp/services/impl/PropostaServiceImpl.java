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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PropostaServiceImpl implements PropostaService {

    private final PropostaRepository propostaRepository;
    private final UsuarioRepository usuarioRepository;
    @Override
    @Transactional
    public PropostaResponseDto create(PropostaRequestDto propostaRequestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(propostaRequestDto);
        this.propostaRepository.save(proposta);
        return PropostaMapper.INSTANCE.convertEntityToPropostaResponseDto(proposta);

    }
}
