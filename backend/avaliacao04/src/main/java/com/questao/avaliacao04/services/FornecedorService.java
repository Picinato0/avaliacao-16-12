package com.questao.avaliacao04.services;

import com.questao.avaliacao04.exceptions.FornecedorNaoEncontradoException;
import com.questao.avaliacao04.models.FornecedorModel;
import com.questao.avaliacao04.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<FornecedorModel> findAll() {
        List<FornecedorModel> result = repository.findAll();
        return result.stream().map(x -> new FornecedorModel(x)).collect(Collectors.toList());
    }

    public FornecedorModel findById(Long id) {
        Optional<FornecedorModel> result = repository.findById(id);
        return result.orElseThrow(() -> new FornecedorNaoEncontradoException("Fornecedor não encontrado. tente novamente"));
    }

    public FornecedorModel insert(FornecedorModel fornecedor){
        FornecedorModel unit = new FornecedorModel();

        unit.setIdFornecedor(fornecedor.getIdFornecedor());
        unit.setNomeFornecedor(fornecedor.getNomeFornecedor());

        unit = repository.save(unit);

        return unit;
    }

    public FornecedorModel update(Long id, FornecedorModel update){
        FornecedorModel updated = findById(id);

        updated.setNomeFornecedor(update.getNomeFornecedor());

        repository.save(updated);

        return updated;
    }

    public void delete(Long id){
        repository.delete(findById(id));
    }

}