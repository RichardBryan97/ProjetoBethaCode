package com.trabalhobethacode.vendas.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Getter@Setter
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRegistroVenda;

    @JoinColumn(name ="idCliente")
    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @JoinColumn(name = "idProduto")
    @OneToOne(fetch = FetchType.LAZY)
    private Produto produto;


}
