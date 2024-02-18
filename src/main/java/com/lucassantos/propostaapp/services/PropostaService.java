package com.lucassantos.propostaapp.services;

import com.lucassantos.propostaapp.dtos.PropostaRequestDto;
import com.lucassantos.propostaapp.dtos.PropostaResponseDto;

public interface PropostaService {

    public PropostaResponseDto create(PropostaRequestDto propostaRequestDto);
}
