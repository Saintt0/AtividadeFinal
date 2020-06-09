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
import javax.persistence.UniqueConstraint;

@Entity
public class Servicos implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int tipo;

    @ManyToMany
    @JoinTable(
        name = "CABELEREIROSERVICO",
        uniqueConstraints = @UniqueConstraint(columnNames = {"ID_CABELEREIRO", "ID_SERVICO"}),
        joinColumns = @JoinColumn(name = "ID_SERVICO"),
        inverseJoinColumns = @JoinColumn(name = "ID_CABELEREIRO")
    )
    private List<Cabelereiro> cabelereiros;

    @ManyToMany
    @JoinTable(
        name = "SERVICOAGENDAMENTO",
        uniqueConstraints = @UniqueConstraint(columnNames = {"ID_AGENDAMENTO", "ID_SERVICO"}),
        joinColumns = @JoinColumn(name = "ID_SERVICO"),
        inverseJoinColumns = @JoinColumn(name = "ID_AGENDAMENTO")
    )
    private List<Agendamento> agendamentos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<Cabelereiro> getCabelereiros() {
        return cabelereiros;
    }

    public void setCabelereiros(List<Cabelereiro> cabelereiros) {
        this.cabelereiros = cabelereiros;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    @Override
    public String toString() {
        return "Servicos [agendamentos=" + agendamentos + ", id=" + id + ", cabelereiros=" + cabelereiros + ", tipo="
                + tipo + "]";
    }


}