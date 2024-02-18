package com.lucassantos.propostaapp.services;

import com.lucassantos.propostaapp.dtos.proposta.PropostaRequestDto;
import com.lucassantos.propostaapp.dtos.proposta.PropostaResponseDto;

public interface PropostaService {

    public PropostaResponseDto create(PropostaRequestDto propostaRequestDto);
}
