package com.lucassantos.propostaapp.controllers;

import com.lucassantos.propostaapp.dtos.proposta.PropostaRequestDto;
import com.lucassantos.propostaapp.dtos.proposta.PropostaResponseDto;
import com.lucassantos.propostaapp.services.impl.PropostaServiceImpl;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/proposta")
public class PropostaController {

    private final PropostaServiceImpl propostaServiceImpl;

    @PostMapping
    public ResponseEntity<PropostaResponseDto> criarProposta(@RequestBody PropostaRequestDto requestDto) {
        PropostaResponseDto responseDto = propostaServiceImpl.create(requestDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(responseDto.getId()).toUri();
        return ResponseEntity.created(uri).body(responseDto);
    }

    @GetMapping
    public ResponseEntity<Page<PropostaResponseDto>> buscarTodasAsPropostasPaginadas(Pageable pageable){
        Page<PropostaResponseDto> responseDtos = propostaServiceImpl.findAllPaged(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(responseDtos);
    }

}
