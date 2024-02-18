package com.lucassantos.propostaapp.mappers;

import com.lucassantos.propostaapp.dtos.PropostaRequestDto;
import com.lucassantos.propostaapp.entities.Proposta;
import org.mapstruct.Mapper;

@Mapper
public interface PropostaMapper {
    Proposta convertDtoToProposta(PropostaRequestDto propostaRequestDto);
}
