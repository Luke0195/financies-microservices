package com.lucassantos.propostaapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ira gerar um id sequenciador.
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private BigDecimal renda;
    @OneToOne(cascade = CascadeType.PERSIST) // salva o usuário primeiro para depois persistir a proposta.
    @JoinColumn(name = "proposta_id")
    private Proposta proposta;

}
