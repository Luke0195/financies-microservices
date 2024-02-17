package com.lucassantos.propostaapp.controllers;

import com.lucassantos.propostaapp.dtos.PropostaRequestDto;
import com.lucassantos.propostaapp.dtos.PropostaResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @PostMapping
    public ResponseEntity<PropostaResponseDto> criarProposta(@Valid @RequestBody PropostaRequestDto dto){
        return null;
    }
}
