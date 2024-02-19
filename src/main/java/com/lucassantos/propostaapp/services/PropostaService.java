package com.lucassantos.propostaapp.services;

import com.lucassantos.propostaapp.dtos.proposta.PropostaRequestDto;
import com.lucassantos.propostaapp.dtos.proposta.PropostaResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PropostaService {

    PropostaResponseDto create(PropostaRequestDto propostaRequestDto);
    Page<PropostaResponseDto> findAllPaged(Pageable pageable);
}
