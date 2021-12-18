import React from  'react';
import {Link} from "react-router-dom";

function HomeProduto(){
    return(
        <>
            <section className="botoes-menu">
                <ul>
                    <li>
                        <Link to="/lista">
                            <button id="botao-index" type="button" className="botoes-menu">Listar</button>
                        </Link>
                    </li>
                    <li>
                        <Link to="/criar">
                            <button id="botao-create" type="button" className="botoes-menu">Criar</button>
                        </Link>
                    </li>
                    <li>
                        <Link to="/produtos/delete">
                            <button id="botao-delete" type="button" className="botoes-menu">Deletar</button>
                        </Link>
                    </li>
                    <li>    
                        <Link to="/produtos/editar">
                            <button id="botao-update" type="button" className="botoes-menu">Editar</button>
                        </Link>
                    </li>                    
                </ul>
            </section>
        </>
    );
}
export default HomeProduto;