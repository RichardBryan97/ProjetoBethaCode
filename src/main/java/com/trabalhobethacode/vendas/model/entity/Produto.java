package com.trabalhobethacode.vendas.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Getter@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduto;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column
    @Min(value = 0, message = "Produto não pode ter valor menor que zero")
    private Double Preço;

    public Produto(){

    }
    public Produto(String nome, Double preço) {
        this.nome = nome;
        Preço = preço;
    }


}
