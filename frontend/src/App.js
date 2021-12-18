import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import Menu from './pages/Home/Menu';
import Home from './pages/Produto/HomeProduto';
import Criar from './pages/Produto/Criar';
import Lista from './pages/Produto/Lista';
import Delete from './pages/Produto/Delete';
import Editar from './pages/Produto/Editar';
import HomeFornecedor from './pages/Fornecedor/HomeFornecedor';

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/" exact component={Menu} />
        <Route path="/homeProduto" component={Home} />
        <Route path="/criar" component={Criar} />
        <Route path="/lista" component={Lista} />
        <Route path="/produtos/delete" component={Delete} />
        <Route path="/produtos/editar" component={Editar} />
        <Route path="/homeFornecedor" component={HomeFornecedor} />
      </Switch>
    </Router>
  );
}

export default App;