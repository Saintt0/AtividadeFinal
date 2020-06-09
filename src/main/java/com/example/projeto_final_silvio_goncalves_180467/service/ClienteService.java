package com.example.projeto_final_silvio_goncalves_180467.service;

import java.util.List;

import com.example.projeto_final_silvio_goncalves_180467.entity.Cliente;
import com.example.projeto_final_silvio_goncalves_180467.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository cr;

    public Cliente getClienteById(Integer codigo){
        return cr.findById(codigo).get();
    }

    public void cadastrar(Cliente c){
        cr.save(c);
    }

    public void remover(Cliente c){
        cr.delete(c);
    } 

    public List<Cliente> getTodoClientes(){
        return cr.findAll();
    }
    


}