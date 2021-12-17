package com.questao.avaliacao04.services;

import com.questao.avaliacao04.exceptions.ProdutoNaoEncontradoException;
import com.questao.avaliacao04.models.ProdutoModel;
import com.questao.avaliacao04.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<ProdutoModel> findAll() {
        List<ProdutoModel> result = repository.findAll();
        return result.stream().map(x -> new ProdutoModel(x)).collect(Collectors.toList());
    }

    public ProdutoModel findById(Long id) {
        Optional<ProdutoModel> result = repository.findById(id);
        return result.orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado. tente novamente"));
    }

//    public ProdutoModel findByNomeProduto(String nome) {
//        Optional<ProdutoModel> found = ProdutoRepository.findByNomeProduto(nome);
//        return found.orElse(null);
//    }

    public ProdutoModel insert(ProdutoModel produto){
        ProdutoModel unit = new ProdutoModel();

        unit.setIdProduto(produto.getIdProduto());
        unit.setNomeProduto(produto.getNomeProduto());
        unit.setEstoqueProduto(produto.getEstoqueProduto());
        unit.setPrecoVenda(produto.getPrecoVenda());
        unit.setPrecoCompra(produto.getPrecoCompra());

        unit = repository.save(unit);

        return unit;
    }

    public ProdutoModel update(Long id, ProdutoModel update){
        ProdutoModel updated = findById(id);

        updated.setNomeProduto(update.getNomeProduto());
        updated.setEstoqueProduto(update.getEstoqueProduto());
        updated.setPrecoVenda(update.getPrecoVenda());
        updated.setPrecoCompra(update.getPrecoCompra());


        repository.save(updated);

        return updated;
    }

    public void delete(Long id){
        repository.delete(findById(id));
    }

}