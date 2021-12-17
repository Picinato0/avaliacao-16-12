package com.questao.avaliacao04.services;

import com.questao.avaliacao04.exceptions.ProdutoNaoEncontradoException;
import com.questao.avaliacao04.exceptions.TipoProdutoNaoEncontradoException;
import com.questao.avaliacao04.models.ProdutoModel;
import com.questao.avaliacao04.models.TipoProdutoModel;
import com.questao.avaliacao04.repositories.TipoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoProdutoService {

    @Autowired
    private TipoProdutoRepository repository;

    public List<TipoProdutoModel> findAll() {
        List<TipoProdutoModel> result = repository.findAll();
        return result.stream().map(x -> new TipoProdutoModel(x)).collect(Collectors.toList());
    }

    public TipoProdutoModel findById(Long id) {
        Optional<TipoProdutoModel> result = repository.findById(id);
        return result.orElseThrow(() -> new TipoProdutoNaoEncontradoException("Tipo de Produto não encontrado. tente novamente"));
    }

    public TipoProdutoModel insert(TipoProdutoModel tipoProduto){
        TipoProdutoModel unit = new TipoProdutoModel();

        unit.setIdTipoProduto(tipoProduto.getIdTipoProduto());
        unit.setNomeTipoProduto(tipoProduto.getNomeTipoProduto());

        unit = repository.save(unit);

        return unit;
    }

    public TipoProdutoModel update(Long id, TipoProdutoModel update){
        TipoProdutoModel updated = findById(id);

        updated.setNomeTipoProduto(update.getNomeTipoProduto());

        repository.save(updated);

        return updated;
    }

    public void delete(Long id){
        repository.delete(findById(id));
    }

}