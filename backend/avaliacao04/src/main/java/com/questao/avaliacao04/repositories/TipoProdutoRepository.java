package com.questao.avaliacao04.repositories;

import com.questao.avaliacao04.models.TipoProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoProdutoRepository extends JpaRepository<TipoProdutoModel, Long> {
    Optional<TipoProdutoModel> findByNomeTipoProduto(String nome);
}
