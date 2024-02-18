package com.lucassantos.propostaapp.services.impl;

import com.lucassantos.propostaapp.dtos.usuario.UsuarioRequestDto;
import com.lucassantos.propostaapp.dtos.usuario.UsuarioResponseDto;
import com.lucassantos.propostaapp.repositories.UsuarioRepository;
import com.lucassantos.propostaapp.services.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl  implements UsuarioService {

    private final UsuarioRepository usuarioRepository;


    @Override
    public UsuarioResponseDto create(UsuarioRequestDto usuarioRequestDto) {
        return null;
    }
}
