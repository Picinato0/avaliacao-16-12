import { Component } from "react";
import React from  'react';
import api from "../../api";

class Lista extends Component {
    state = {
      produtos: [],
    };
  
    async componentDidMount() {
      const responseProdutos = await api.get("/produtos");
      this.setState({ produtos: responseProdutos.data });
      console.log (responseProdutos.data);
    }
  
    render() {
      const { produtos } = this.state;
      return (
        <div className="listar">
            <div className="produtos-findall">
                {console.log(produtos)}
                {produtos.map((produto) => (
                <div key={produto.id}>
                    <p>
                    <span>ID: </span>
                    {produto.idProduto}
                    </p>
                    <p>
                    <span>Nome: </span>
                    {produto.nomeProduto}
                    </p>
                    <p>
                    <span>Estoque: </span>
                    {produto.estoqueProduto}
                    </p>
                    <p>
                    <span>Preco Venda: </span>
                    {produto.precoVenda}
                    </p>
                    <p>
                    <span>Preco Compra: </span>
                    {produto.precoCompra}
                    </p>
                    <p>
                    <span>Tipo Produto: </span>
                    {produto.tipoProdutos}
                    </p>
                    <p>
                    <span>Fornecedores: </span>
                    {produto.fornecedores}
                    </p>
                </div>
                ))}
            </div>
        </div>
      );
    }
}
export default Lista;