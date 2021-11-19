package com.trabalhobethacode.vendas.model.repository;

import com.trabalhobethacode.vendas.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
