package com.example.projeto_final_silvio_goncalves_180467.controller;

import com.example.projeto_final_silvio_goncalves_180467.entity.Cliente;
import com.example.projeto_final_silvio_goncalves_180467.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {
    
    @Autowired
    private ClienteService cs;

    @GetMapping("/cliente")
    public ModelAndView getClientes()
    {
        ModelAndView mv = new ModelAndView("ClienteTemplate");

        mv.addObject("cliente", new Cliente());
        mv.addObject("clientes", cs.getTodoClientes());

        return mv;
    }

    @PostMapping("cadastrarcliente")
    public String CadastrarCliente(@ModelAttribute Cliente c)
    {
        cs.cadastrar(c);

        return "redirect:/cliente";
    }

    @GetMapping("/removercliente/{id}")
    public String removerCliente(@PathVariable (name = "id") Integer id)
    {
        Cliente c = cs.getClienteById(id);
        cs.remover(c);

        return "redirect:/cliente";
    }
}