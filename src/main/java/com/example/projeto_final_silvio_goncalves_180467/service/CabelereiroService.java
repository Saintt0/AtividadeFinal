package com.example.projeto_final_silvio_goncalves_180467.service;

import java.util.List;

import com.example.projeto_final_silvio_goncalves_180467.entity.Cabelereiro;
import com.example.projeto_final_silvio_goncalves_180467.repository.CabelereiroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabelereiroService {
    
    @Autowired
    private CabelereiroRepository cr;


    public Cabelereiro getCabelereiroById(Integer codigo) {
		return cr.findById(codigo).get();
    } 

    public void cadastrar(Cabelereiro c){
        cr.save(c);
    }
    
    public void remover(Cabelereiro c) {
        cr.delete(c);
    }
    
    public List<Cabelereiro> getTodosCabelereiros(){
        return cr.findAll();
    }
}