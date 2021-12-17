package com.questao.avaliacao04.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_tipoproduto")
public class TipoProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoProduto;

    private String nomeTipoProduto;

    @JsonBackReference
    @OneToMany(mappedBy = "tipoProdutos", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProdutoModel> produtos = new ArrayList<>();

    public TipoProdutoModel(TipoProdutoModel entity) {
        idTipoProduto = entity.getIdTipoProduto();
        nomeTipoProduto = entity.getNomeTipoProduto();
        produtos = entity.getProdutos().stream().map(produto -> new ProdutoModel(produto)).collect(Collectors.toList());
    }
}