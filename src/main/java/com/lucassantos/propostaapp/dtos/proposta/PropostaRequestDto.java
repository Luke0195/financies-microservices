package com.lucassantos.propostaapp.dtos.proposta;

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
public class PropostaRequestDto implements Serializable {

    private String nome;
    @NotBlank(message = "The field sobrenome is required")
    private String sobrenome;

    @NotBlank(message = "The field telefone is required")
    private String telefone;

    @CPF(message = "Please provided a valid CPF")
    @NotBlank(message = "The field cpf must be required")
    private String cpf;

    @NotNull(message = "The field renda must be required")
    @Min(1)
    private BigDecimal renda;

    @JsonProperty("valor_solicitado")
    @NotNull(message = "The field valor_solicitado must be required")
    @Min(1)
    private Double valorSolicitado;

    @NotNull(message = "The field user_id is required")
    @JsonProperty("user_id")
    private Long userId;


}
