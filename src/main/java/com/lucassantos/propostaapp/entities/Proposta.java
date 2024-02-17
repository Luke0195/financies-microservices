package com.lucassantos.propostaapp.entities;

import jakarta.persistence.*;
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
@Entity
@Table(name="tb_proposta")
public class Proposta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="valor_solicitado")
    private BigDecimal valorSolicitado;
    @Column(name="prazo_pagamento")
    private Integer prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;
    @OneToOne(mappedBy = "proposta")
    private Usuario usuario;
}
