package com.lucassantos.propostaapp.dtos.usuario;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioRequestDto implements Serializable {

    @NotBlank(message = "The field name is required")
    private String nome;

    @NotBlank(message = "The field sobrenome is required")
    private String sobrenome;

    @NotBlank(message = "The field cpf is required")
    @CPF(message = "Please provided a valid CPF")
    private String cpf;

    @NotBlank(message = "The field telefone is required")
    private String telefone;

    @NotNull(message = "The field renda must be required")
    @Min(1)
    private BigDecimal renda;

    @JsonProperty("proposta_id")
    private Long propostaId;
}
