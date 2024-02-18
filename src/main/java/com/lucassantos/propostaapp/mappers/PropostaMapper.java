package com.lucassantos.propostaapp.mappers;

import com.lucassantos.propostaapp.dtos.PropostaRequestDto;
import com.lucassantos.propostaapp.entities.Proposta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface PropostaMapper {
    @Mapping(target= "usuario.nome", source = "nome")
    @Mapping(target= "usuario.sobrenome", source = "sobrenome")
    @Mapping(target= "usuario.cpf", source="cpf")
    @Mapping(target= "usuario.telefone", source="telefone")
    @Mapping(target= "usuario.renda", source = "renda")
    @Mapping(target="id", ignore = true) // ignora o campo
    @Mapping(target = "aprovada", ignore = true)
    @Mapping(target = "integrada", ignore=true)
    @Mapping(target = "observacao", ignore = true)
    Proposta convertDtoToProposta(PropostaRequestDto propostaRequestDto);


}

