package com.lucassantos.propostaapp.dtos.usuario;

import com.lucassantos.propostaapp.entities.Proposta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponseDto implements Serializable {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private BigDecimal renda;
    private Proposta proposta;
}
