package com.lucassantos.propostaapp.controllers;

import com.lucassantos.propostaapp.dtos.usuario.UsuarioRequestDto;
import com.lucassantos.propostaapp.dtos.usuario.UsuarioResponseDto;
import com.lucassantos.propostaapp.services.impl.UsuarioServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioServiceImpl;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> criarUsuario(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto responseDto = usuarioServiceImpl.create(usuarioRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
