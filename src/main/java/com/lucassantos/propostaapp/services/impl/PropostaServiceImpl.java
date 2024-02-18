package com.lucassantos.propostaapp.services.impl;

import com.lucassantos.propostaapp.dtos.PropostaRequestDto;
import com.lucassantos.propostaapp.dtos.PropostaResponseDto;
import com.lucassantos.propostaapp.repositories.PropostaRepository;
import com.lucassantos.propostaapp.services.PropostaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropostaServiceImpl implements PropostaService {

    private PropostaRepository propostaRepository;
    @Override
    public PropostaResponseDto create(PropostaRequestDto propostaRequestDto) {
        return null;
    }
}
