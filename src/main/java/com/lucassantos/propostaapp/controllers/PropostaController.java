package com.lucassantos.propostaapp.controllers;

import com.lucassantos.propostaapp.dtos.proposta.PropostaRequestDto;
import com.lucassantos.propostaapp.dtos.proposta.PropostaResponseDto;
import com.lucassantos.propostaapp.services.impl.PropostaServiceImpl;

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


    private final PropostaServiceImpl propostaServiceImpl;
    @PostMapping
    public ResponseEntity<PropostaResponseDto> criarProposta(@RequestBody PropostaRequestDto requestDto){
        PropostaResponseDto responseDto = propostaServiceImpl.create(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
