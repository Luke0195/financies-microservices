package com.lucassantos.propostaapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PropostaResponseDto implements Serializable {

    private Long id;

    private String nome;

    private String sobrenome;

    private String telefone;

    private String cpf;

    private BigDecimal renda;

    @JsonProperty("valor_solicitado")
    private Double valorSolicitado;

    private Boolean aprovado;

    private String observacao;

}
