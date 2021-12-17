package com.questao.avaliacao04.controllers;


import com.questao.avaliacao04.models.ProdutoModel;
import com.questao.avaliacao04.models.TipoProdutoModel;
import com.questao.avaliacao04.repositories.TipoProdutoRepository;
import com.questao.avaliacao04.services.TipoProdutoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/tipo-produto")
public class TipoProdutoController {

    @Autowired
    private TipoProdutoService service;
    private TipoProdutoRepository repository;

    @GetMapping
    public ResponseEntity<List<TipoProdutoModel>> findAll() {
        List<TipoProdutoModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TipoProdutoModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TipoProdutoModel> insert(@RequestBody TipoProdutoModel entity) {
        try {
            TipoProdutoModel obj = service.insert(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getIdTipoProduto()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TipoProdutoModel> update(@PathVariable Long id, @RequestBody TipoProdutoModel update){
        return ResponseEntity.ok(service.update(id, update));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("TipoProduto" + id + " deletado!");
    }

}