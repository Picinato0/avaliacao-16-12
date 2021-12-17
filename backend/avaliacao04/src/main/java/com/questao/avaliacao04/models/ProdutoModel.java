package com.questao.avaliacao04.models;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto ;

    private String nomeProduto;
    private String estoqueProduto;
    private String precoVenda;
    private String precoCompra;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoProduto")
    private TipoProdutoModel tipoProdutos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFornecedor")
    private FornecedorModel fornecedores;

    public ProdutoModel(ProdutoModel entity){
        idProduto = entity.getIdProduto();
        nomeProduto = entity.getNomeProduto();
        estoqueProduto = entity.getEstoqueProduto();
        precoVenda = entity.getPrecoVenda();
        precoCompra = entity.getPrecoCompra();
        tipoProdutos = entity.getTipoProdutos();
        fornecedores = entity.getFornecedores();
    }
}
