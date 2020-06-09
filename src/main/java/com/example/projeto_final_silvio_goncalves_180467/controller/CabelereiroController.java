package com.example.projeto_final_silvio_goncalves_180467.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.projeto_final_silvio_goncalves_180467.entity.Agendamento;
import com.example.projeto_final_silvio_goncalves_180467.entity.Cabelereiro;
import com.example.projeto_final_silvio_goncalves_180467.entity.Servicos;
import com.example.projeto_final_silvio_goncalves_180467.service.AgendamenteService;
import com.example.projeto_final_silvio_goncalves_180467.service.CabelereiroService;
import com.example.projeto_final_silvio_goncalves_180467.service.ServicosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CabelereiroController {
    
    @Autowired
    private CabelereiroService cs;

    @Autowired
    private ServicosService ss;

    @Autowired
    private AgendamenteService as;

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

    @GetMapping("/addservicos/{id}")
    public ModelAndView getServicos(@PathVariable (name = "id") Integer id)
    {
        ModelAndView mv = new ModelAndView("Cabelereiro_Servicos");
        Cabelereiro c = cs.getCabelereiroById(id);
        List<Servicos> s = ss.getTodosServicos();

        s.removeAll(c.getServicos());

        mv.addObject(("cabelereiro"), c);
        mv.addObject("servicos", s);

        return mv;

    }

    @PostMapping("/addserv")
    public String ligarServicos(HttpServletRequest req, @RequestParam Integer id)
    {
        Cabelereiro c = cs.getCabelereiroById(id);
        Servicos s = ss.getServicoById(Integer.parseInt(req.getParameter("ids")));

        c.getServicos().add(s);
        cs.cadastrar(c);

        return "redirect:/addservicos/" + id;
    }

    @GetMapping("/mostraragendamentos/{id}")
    public ModelAndView getAgendamentosCabelereiro(@PathVariable (name = "id") Integer id)
    {
        ModelAndView mv = new ModelAndView("Cabelereiro_Agendamento");
        Cabelereiro c = cs.getCabelereiroById(id);
        List<Agendamento> a = as.getTodosAgendamentos();

        mv.addObject(("cabelereiro"), c);
        mv.addObject(("agendamentos"), a);

        return mv;
    }


    
}