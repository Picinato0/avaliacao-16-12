package com.questao.avaliacao04.controllers;

import com.questao.avaliacao04.models.FornecedorModel;
import com.questao.avaliacao04.models.ProdutoModel;
import com.questao.avaliacao04.repositories.FornecedorRepository;

import com.questao.avaliacao04.services.FornecedorService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService service;
    private FornecedorRepository repository;

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> findAll() {
        List<FornecedorModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FornecedorModel> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<FornecedorModel> insert(@RequestBody FornecedorModel entity) {
        try {
            FornecedorModel obj = service.insert(entity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getIdFornecedor()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ServiceException e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FornecedorModel> update(@PathVariable Long id, @RequestBody FornecedorModel update){
        return ResponseEntity.ok(service.update(id, update));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Fornecedor" + id + " deletado!");
    }

}