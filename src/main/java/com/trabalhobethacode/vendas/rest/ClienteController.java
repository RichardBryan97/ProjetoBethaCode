package com.trabalhobethacode.vendas.rest;

import com.trabalhobethacode.vendas.model.entity.Cliente;
import com.trabalhobethacode.vendas.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/Cliente")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@Valid @RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Cliente " + id +
                " não existe na aplicação"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorID(@PathVariable Integer id){
        repository.findById(id).map(cliente -> {repository.delete(cliente); return Void.TYPE;})
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "O Cliente "+id+" Não existe em nossa aplicação"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void AtualizarCliente(@PathVariable Integer id,@Valid @RequestBody Cliente dadoAtualizado){
        repository.findById(id).map(cliente -> {
            cliente.setNome(dadoAtualizado.getNome());
            return repository.save(cliente);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
