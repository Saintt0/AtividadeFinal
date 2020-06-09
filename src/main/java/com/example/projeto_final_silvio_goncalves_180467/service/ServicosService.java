package com.example.projeto_final_silvio_goncalves_180467.service;

import java.util.List;

import com.example.projeto_final_silvio_goncalves_180467.entity.Servicos;
import com.example.projeto_final_silvio_goncalves_180467.repository.ServicosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicosService {

    @Autowired
    private ServicosRepository sr;

    public List<Servicos> getTodosServicos(){
        return sr.findAll();
    }

    public Servicos getServicoById(Integer id){
        return sr.findById(id).get();
    }

    public void cadastrarServicos(Servicos s){
        sr.save(s);
    }

    public void removerServicos(Servicos s){
        sr.delete(s);
    }
}