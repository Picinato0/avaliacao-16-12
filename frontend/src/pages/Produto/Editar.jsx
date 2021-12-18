import { useState } from "react";
import api from '../../api'

export default function Update() {

    const [id, setId] = useState("");
    const [produtoNome, setProdutoNome] = useState("");
    const [produtoEstoque, setProdutoEstoque] = useState("");
    const [produtoVenda, setProdutoVenda] = useState("");
    const [produtoCompra, setProdutoCompra] = useState("");

    const toEdit = {
        nomeProduto: produtoNome,
        estoqueProduto: produtoEstoque,
        precoVenda: produtoVenda,
        precoCompra: produtoCompra

    }

    async function handleSubmit(e) {
        e.preventDefault();
        await edit(toEdit);
      }
    
      async function edit(toEdit) {
        const response = await api.put("produtos/" + id, toEdit)
    
        if (response.status == 200) {
          alert("Contato editado com Sucesso!")
        } else {
          alert("Ocorreu um erro")
        }
      }

      return (
        <div className="upadate-page">
          <div>
            <h2>Editando Contato</h2>
          </div>
          <form onSubmit={(e) => handleSubmit(e)}>
            <div className="update-form">
              <label>Nome:</label>
              <input type="text" name="nomeProduto" onChange={value => setProdutoNome(value.target.value)} value={produtoNome} />

              <label>Estoque:</label>
              <input type="text" name="estoqueProduto" onChange={value => setProdutoEstoque(value.target.value)} value={produtoEstoque} />
    
              <label>Preco venda:</label>
              <input type="text" name="precoVenda" onChange={value => setProdutoVenda(value.target.value)} value={produtoVenda} />

              <label>Preco compra:</label>
              <input type="text" name="precoCompra" onChange={value => setProdutoCompra(value.target.value)} value={produtoCompra} />
              
              <label>id</label>
              <input type="number" name="id" onChange={value => setId(value.target.value)} value={id} />
              <button type="submit" value="Editar">Confirmar</button>
            </div>
          </form>
        </div>
    
      );
    }