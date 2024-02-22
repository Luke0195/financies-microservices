package com.lucassantos.propostaapp.services;

import com.lucassantos.propostaapp.dtos.proposta.PropostaResponseDto;

public interface NotificacaoService {
    void notificar(PropostaResponseDto propostaResponseDto, String exchange);
}
