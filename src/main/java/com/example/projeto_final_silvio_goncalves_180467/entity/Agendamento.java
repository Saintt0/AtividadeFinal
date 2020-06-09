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
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;


@Entity
public class Agendamento implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String data;
    private String horario;
    
    @ManyToOne
    @JoinColumn(name = "ID_AGENDADO")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_MARCADO")
    private Cabelereiro cabelereiro;

    @ManyToMany
    @JoinTable(
        name = "SERVICOAGENDAMENTO",
        uniqueConstraints = @UniqueConstraint(columnNames = {"ID_AGENDAMENTO","ID_SERVICO"}),
        joinColumns = @JoinColumn(name = "ID_AGENDAMENTO"),
        inverseJoinColumns = @JoinColumn(name = "ID_SERVICO")
    )
    private List<Servicos> servicos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cabelereiro getCabelereiro() {
        return cabelereiro;
    }

    public void setCabelereiro(Cabelereiro cabelereiro) {
        this.cabelereiro = cabelereiro;
    }

    public List<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servicos> servicos) {
        this.servicos = servicos;
    }

    @Override
    public String toString() {
        return "Agendamento [cliente=" + cliente + ", data=" + data + ", horario=" + horario + ", id=" + id
                + ", cabelereiro=" + cabelereiro + ", servicos=" + servicos + "]";
    }

    

}