package com.trabalhobethacode.vendas.rest;

import com.trabalhobethacode.vendas.model.entity.Cliente;
import com.trabalhobethacode.vendas.model.entity.Produto;
import com.trabalhobethacode.vendas.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/Produto")
public class ProdutoController {

    private final ProdutoRepository repository;

    @Autowired
    public ProdutoController(ProdutoRepository repository) { this.repository = repository;  }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@Valid @RequestBody Produto produto){
        return repository.save(produto);
    }

    @GetMapping("{id}")
    public Produto acharPorId(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Produto " + id +
                " não existe na aplicação"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorID(@PathVariable Integer id){
        repository.findById(id).map(produto -> {repository.delete(produto); return Void.TYPE;})
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "O Produto "+id+" Não existe em nossa aplicação"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void AtualizarProduto(@PathVariable Integer id,@Valid @RequestBody Produto dadoAtualizado){
        repository.findById(id).map(produto -> {
            produto.setNome(dadoAtualizado.getNome());
            produto.setPreço(dadoAtualizado.getPreço());
            return repository.save(produto);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
