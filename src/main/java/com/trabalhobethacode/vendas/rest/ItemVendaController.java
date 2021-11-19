package com.trabalhobethacode.vendas.rest;

import com.trabalhobethacode.vendas.model.Dto.ItemVendaDTO;
import com.trabalhobethacode.vendas.model.entity.Cliente;
import com.trabalhobethacode.vendas.model.entity.ItemVenda;
import com.trabalhobethacode.vendas.model.entity.Produto;
import com.trabalhobethacode.vendas.model.repository.ClienteRepository;
import com.trabalhobethacode.vendas.model.repository.ItemVendaRepository;
import com.trabalhobethacode.vendas.model.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ItemVendido")
@RequiredArgsConstructor
public class ItemVendaController {

    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemVendaRepository itemVendaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemVenda salvar(@Valid @RequestBody ItemVendaDTO itemVendaDTO){

        Integer idCliente = itemVendaDTO.getIdCliente();
        Cliente clienteASalvar = clienteRepository.findById(idCliente).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "O Cliente "+ idCliente +" não existe na aplicação"));

        Integer idProduto = itemVendaDTO.getIdProduto();
        Produto produtoASalvar = produtoRepository.findById(idProduto).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "O Produto "+ idProduto+" Não existe na aplicação"));

        ItemVenda itemVendaASalvar = new ItemVenda();
        itemVendaASalvar.setCliente(clienteASalvar);
        itemVendaASalvar.setProduto(produtoASalvar);

        return itemVendaRepository.save(itemVendaASalvar);
    }

    @GetMapping("{id}")
    public ItemVenda acharPorId(@PathVariable Integer id){
        return itemVendaRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND
                ,"Venda "+id+ " não foi encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorID(@PathVariable Integer id){
        itemVendaRepository.findById(id).map(itemVenda -> {itemVendaRepository.delete(itemVenda); return Void.TYPE;})
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "O Item  "+id+" Não existe em nossa aplicação"));
    }

     /*@PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Atualizar(@PathVariable Integer id,@Valid @RequestBody ItemVenda dadoAtualizado){
        repository.findById(id).map(itemVenda -> {
            itemVenda.setNome(dadoAtualizado.getNome());
            return repository.save(itemVenda);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }*/
}
