package com.lucassantos.propostaapp.repositories;

import com.lucassantos.propostaapp.entities.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

}
