import React from  'react';
import {Link} from "react-router-dom";

function HomeFornecedor(){
    return(
        <>
            <section className="botoes-menu">
                <ul>
                    <li>
                        <Link to="/fornecedor/lista">
                            <button id="botao-index-fornecedor" type="button" className="botoes-menu">Listar</button>
                        </Link>
                    </li>
                    <li>
                        <Link to="/fornecedor/criar">
                            <button id="botao-create-fornecedor" type="button" className="botoes-menu">Criar</button>
                        </Link>
                    </li>
                    <li>
                        <Link to="/fornecedor/delete">
                            <button id="botao-delete-fornecedor" type="button" className="botoes-menu">Deletar</button>
                        </Link>
                    </li>
                    <li>    
                        <Link to="/fornecedor/editar">
                            <button id="botao-update-fornecedor" type="button" className="botoes-menu">Editar</button>
                        </Link>
                    </li>                    
                </ul>
            </section>
        </>
    );
}
export default HomeFornecedor;