package com.lucassantos.propostaapp.mapper;

import com.lucassantos.propostaapp.dtos.usuario.UsuarioRequestDto;
import com.lucassantos.propostaapp.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper( UsuarioMapper.class);
    @Mapping(target = "proposta.id", source = "propostaId")
    Usuario convertDtoToUsuario(UsuarioRequestDto usuarioRequestDto);
}
