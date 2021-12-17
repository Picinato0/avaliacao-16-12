package com.questao.avaliacao04.repositories;

import com.questao.avaliacao04.models.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
    Optional<FornecedorModel> findByNomeFornecedor(String nome);
}