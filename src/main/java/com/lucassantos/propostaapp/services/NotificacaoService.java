package com.lucassantos.propostaapp.services;

import com.lucassantos.propostaapp.dtos.proposta.PropostaResponseDto;
import com.lucassantos.propostaapp.entities.Proposta;

public interface NotificacaoService {
    void notificar(Proposta proposta, String exchange);
}
