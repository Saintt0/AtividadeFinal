package com.example.projeto_final_silvio_goncalves_180467.controller;

import com.example.projeto_final_silvio_goncalves_180467.entity.Servicos;
import com.example.projeto_final_silvio_goncalves_180467.service.ServicosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServicosController {

    @Autowired
    private ServicosService ss;

    @GetMapping("/servicos")
    public ModelAndView getServicos()
    {
        ModelAndView mv = new ModelAndView("ServicosTemplate");

        mv.addObject("Servico", new Servicos());
        mv.addObject("Servicos", ss.getTodosServicos());

        return mv;
    }

    @PostMapping("/cadastrarservicos")
    public String cadastrarServicos(@ModelAttribute Servicos s)
    {
        ss.cadastrarServicos(s);

        return "redirect:/servicos";
    }

    @GetMapping("/removerservicos/{id}")
    public String removerServicos(@PathVariable (name = "id") Integer id)
    {
        Servicos s = ss.getServicoById(id);
        ss.removerServicos(s);

        return "redirect:/servicos";
    }

    @GetMapping("/atualizarservicos/{id}")
    public ModelAndView atualizarServicos(@PathVariable (name = "id") Integer id)
    {
        ModelAndView mv = new ModelAndView("AtualizarServicos");
        Servicos s = ss.getServicoById(id);

        mv.addObject("servicos", s);
        return mv;
    }

}