package com.questao.avaliacao04.repositories;

import com.questao.avaliacao04.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel> findByNomeProduto(String nome);
}
