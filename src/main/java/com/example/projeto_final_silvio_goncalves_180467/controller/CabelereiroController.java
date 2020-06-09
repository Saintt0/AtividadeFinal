package com.example.projeto_final_silvio_goncalves_180467.controller;

import com.example.projeto_final_silvio_goncalves_180467.entity.Cabelereiro;
import com.example.projeto_final_silvio_goncalves_180467.service.CabelereiroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CabelereiroController {
    
    @Autowired
    private CabelereiroService cs;

    @GetMapping("/cabelereiro")
    public ModelAndView getCabelereiro()
    {
        ModelAndView mv = new ModelAndView("CabelereiroTemplate");

        mv.addObject("cabelereiro", new Cabelereiro());
        mv.addObject("cabelereiros", cs.getTodosCabelereiros());

        return mv;
    }

    @PostMapping("/cadastrarcabelereiro")
    public String cadastrarCabeleiro(@ModelAttribute Cabelereiro c)
    {
        cs.cadastrar(c);

        return "redirect:/cabelereiro";
    }

    @GetMapping("/removercabelereiro/{id}")
    public String removerCabelereiro(@PathVariable (name = "id") Integer id)
    {
        Cabelereiro c = cs.getCabelereiroById(id);
        cs.remover(c);

        return "redirect:/cabelereiro";
    }

    @GetMapping("/atualizarcabelereiro/{id}")
    public ModelAndView atualizarCabelereiro(@PathVariable (name = "id") Integer id)
    {
        ModelAndView mv = new ModelAndView("AtualizarCabelereiro");
        Cabelereiro c = cs.getCabelereiroById(id);

        mv.addObject("cabelereiro", c);
        return mv;
    }

    
}