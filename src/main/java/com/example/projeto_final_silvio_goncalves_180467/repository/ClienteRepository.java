package com.example.projeto_final_silvio_goncalves_180467.repository;

import com.example.projeto_final_silvio_goncalves_180467.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}