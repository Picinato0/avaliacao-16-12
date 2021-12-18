import React from "react";
import { Link } from 'react-router-dom';

function Menu() {
    return (
                <nav>
                    <ul className='options'>
                        <Link id="botao-produto" to="/homeProduto"><li>Produto</li></Link>
                        <Link to="/homeFornecedor"><li>Fornecedor</li></Link>
                        {/* <Link to="/tipoProduto"><li>Tipo de Produto</li></Link> */}
                    </ul>
                </nav>
    );
}

export default Menu;