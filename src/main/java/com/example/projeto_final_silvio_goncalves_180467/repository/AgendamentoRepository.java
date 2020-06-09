package com.example.projeto_final_silvio_goncalves_180467.repository;

import com.example.projeto_final_silvio_goncalves_180467.entity.Agendamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    
}