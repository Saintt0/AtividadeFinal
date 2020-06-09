package com.example.projeto_final_silvio_goncalves_180467.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Profissional implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    
    @OneToMany
    @JoinColumn(name = "ID_AGENDADO")
    private List<Agendamento> agendamentos;

    @ManyToMany
    @JoinTable(
        name = "PROFISSIONALSERVICO",
        uniqueConstraints = @UniqueConstraint(columnNames = {"ID_PROFISSIONAL", "ID_SERVICO"}),
        joinColumns = @JoinColumn(name = "ID_PROFISSIONAL"),
        inverseJoinColumns = @JoinColumn(name = "ID_SERVICO")
    )
    private List<Servicos> servicos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public List<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servicos> servicos) {
        this.servicos = servicos;
    }

    @Override
    public String toString() {
        return "Profissional [agendamentos=" + agendamentos + ", id=" + id + ", nome=" + nome + ", servicos=" + servicos
                + "]";
    }

}