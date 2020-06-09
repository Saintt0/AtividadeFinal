package com.example.projeto_final_silvio_goncalves_180467.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.projeto_final_silvio_goncalves_180467.entity.Agendamento;
import com.example.projeto_final_silvio_goncalves_180467.entity.Servicos;
import com.example.projeto_final_silvio_goncalves_180467.service.AgendamenteService;
import com.example.projeto_final_silvio_goncalves_180467.service.CabelereiroService;
import com.example.projeto_final_silvio_goncalves_180467.service.ClienteService;
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
public class AgendamenteController {
    
    @Autowired
    private AgendamenteService as;

    @Autowired
    private ClienteService cls;

    @Autowired
    private CabelereiroService cbs;

    @Autowired
    private ServicosService ss;

    @GetMapping("/agendamento")
    public ModelAndView getAgendamentos(){
        ModelAndView mv = new ModelAndView("AgendamentoTemplate");

        mv.addObject("agendamento", new Agendamento());
        mv.addObject("agendamentos", as.getTodosAgendamentos());
        mv.addObject("cabelereiros", cbs.getTodosCabelereiros());
        mv.addObject("clientes", cls.getTodoClientes());

        return mv;
    }

    @PostMapping("/cadastraagendamento")
    public String cadastrarAgendamento(@ModelAttribute Agendamento a)
    {
        as.cadastrarAgendamento(a);

        return "redirec:/agendamento";
    }


    @GetMapping("/removeragendamento/{id}")
    public String removerAgendamento(@PathVariable (name = "id") Integer id)
    {
        Agendamento a = as.getAgendamentoById(id);
        as.removerAgendamento(a);

        return "redirect:/agendamento";
    }

    @GetMapping("/atualizaragendamento/{id}")
    public ModelAndView atualizarAgendamento(@PathVariable (name = "id") Integer id)
    {
        ModelAndView mv = new ModelAndView("AtualizarAgendamento");
        Agendamento a = as.getAgendamentoById(id);

        mv.addObject("agendamento", a);
        mv.addObject("cabelereiros", cbs.getTodosCabelereiros());
        mv.addObject("clientes", cls.getTodoClientes());
        
        return mv;
    }

    @GetMapping("/escservicos/{id}")
    public ModelAndView getServicos(@PathVariable (name = "id") Integer id)
    {
        ModelAndView mv = new ModelAndView("Agendamento_Servicos");
        Agendamento a = as.getAgendamentoById(id);

        mv.addObject("agendamento", a);
        mv.addObject("servicos", a.getCabelereiro().getServicos());

        return mv;
    }

    @PostMapping("/ligarservico")
    public String ligarServicos(HttpServletRequest req, @RequestParam Integet id)
    {
        Agendamento a = as.getAgendamentoById(id);
        Servicos s = ss.getServicoById(Integer.parseInt(req.getParameter("id")));

        a.getServicos().add(s);
        as.cadastrarAgendamento(a);

        return "redirect:/escservicos/" + id;
    }


}