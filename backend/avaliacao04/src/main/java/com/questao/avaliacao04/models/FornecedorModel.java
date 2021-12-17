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
@Table(name = "tb_fornecedores")
public class FornecedorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFornecedor;

    private String nomeFornecedor;

    @JsonBackReference
    @OneToMany(mappedBy = "fornecedores", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProdutoModel> produtos = new ArrayList<>();

    public FornecedorModel(FornecedorModel entity){
        idFornecedor = entity.getIdFornecedor();
        nomeFornecedor = entity.getNomeFornecedor();
        produtos = entity.getProdutos().stream().map(produto -> new ProdutoModel(produto)).collect(Collectors.toList());
    }
}