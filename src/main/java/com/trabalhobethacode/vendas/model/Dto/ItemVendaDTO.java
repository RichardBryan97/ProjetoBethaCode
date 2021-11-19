package com.trabalhobethacode.vendas.model.Dto;

import com.trabalhobethacode.vendas.model.repository.ClienteRepository;
import com.trabalhobethacode.vendas.model.repository.ItemVendaRepository;
import com.trabalhobethacode.vendas.model.repository.ProdutoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ItemVendaDTO {

    private Integer idCliente;
    private Integer idProduto;
    private Integer idRegistroVenda;

    public ItemVendaDTO( ) {

    }
}
