import React, { useState } from 'react';
import api from "../../api";

function Criar(){

    const [produtoNome, setProdutoNome] = useState("");
    const [produtoEstoque, setProdutoEstoque] = useState("");
    const [produtoVenda, setProdutoVenda] = useState("");
    const [produtoCompra, setProdutoCompra] = useState("");

    const handleSubmit = (e) =>{
        e.preventDefault();
        const criarProdutos = {
            nomeProduto: produtoNome,
            estoqueProduto: produtoEstoque,
            precoVenda: produtoVenda,
            precoCompra: produtoCompra
        }
        console.log(criarProdutos)
        api.post('/produtos', criarProdutos).then((resp) => {
            console.log(resp)
        });
    }
    return(
        <>
            <form className="criaProduto-form" onSubmit={handleSubmit}>
                <ul>
                    <li>
                        <input name="nome-input" onChange={value => setProdutoNome(value.target.value)} value={produtoNome} className="criaProduto-input" type="text" placeholder="Nome"></input>
                    </li>
                    <li>
                        <input name="estoque-input" onChange={value => setProdutoEstoque(value.target.value)} value={produtoEstoque} className="criaProduto-input" type="text" placeholder="Estoque"></input>
                    </li>
                    <li>
                        <input name="venda-input" onChange={value => setProdutoVenda(value.target.value)} value={produtoVenda} className="criaProduto-input" type="text" placeholder="Preco Venda"></input>
                    </li>
                    <li>
                        <input name="compra-input" onChange={value => setProdutoCompra(value.target.value)} value={produtoCompra} className="criaProduto-input" type="text" placeholder="Preco Compra"></input>
                    </li>
                    <li>
                        <button name="criaProduto-submit" type="submit" className="criaProduto-input">Submit</button>
                    </li>
                </ul>
            </form>
        </>
    );
}
export default Criar;