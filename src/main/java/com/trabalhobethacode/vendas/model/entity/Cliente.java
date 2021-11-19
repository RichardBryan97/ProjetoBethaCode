package com.trabalhobethacode.vendas.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCliente;
    @Column(nullable = false, length = 100)
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(){

    }
    /* public int getIdCliente() {
        return idCliente;
    }
    private void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNome() {
        return nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }*/

}
