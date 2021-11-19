package com.trabalhobethacode.vendas.model.repository;

import com.trabalhobethacode.vendas.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
