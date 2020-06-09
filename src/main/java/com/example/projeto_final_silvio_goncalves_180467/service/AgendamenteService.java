package com.example.projeto_final_silvio_goncalves_180467.service;

import java.util.List;

import com.example.projeto_final_silvio_goncalves_180467.entity.Agendamento;
import com.example.projeto_final_silvio_goncalves_180467.repository.AgendamentoRepository;

import org.springframework.stereotype.Service;

@Service
public class AgendamenteService {

    private AgendamentoRepository ar;

    public List<Agendamento> getTodosAgendamentos(){
        return ar.findAll();
    }
    public Agendamento getAgendamentoById(Integer id){
        return ar.findById(id).get();
    }

    public void cadastrarAgendamento(Agendamento a){
        ar.save(a);
    }

    public void removerAgendamento(Agendamento a){
        ar.delete(a);
    }
    
}