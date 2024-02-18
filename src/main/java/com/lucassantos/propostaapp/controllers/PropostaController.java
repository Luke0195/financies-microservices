package com.lucassantos.propostaapp.controllers;

import com.lucassantos.propostaapp.dtos.PropostaRequestDto;
import com.lucassantos.propostaapp.dtos.PropostaResponseDto;
import com.lucassantos.propostaapp.services.impl.PropostaServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {


    private PropostaServiceImpl propostaServiceImpl;
    @PostMapping
    public ResponseEntity<PropostaResponseDto> criarProposta(@Valid @RequestBody PropostaRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(propostaServiceImpl.create(requestDto));
    }
}
