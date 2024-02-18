package com.lucassantos.propostaapp.services;

import com.lucassantos.propostaapp.dtos.usuario.UsuarioRequestDto;
import com.lucassantos.propostaapp.dtos.usuario.UsuarioResponseDto;

public interface UsuarioService {
    UsuarioResponseDto create(UsuarioRequestDto usuarioRequestDto);
}
