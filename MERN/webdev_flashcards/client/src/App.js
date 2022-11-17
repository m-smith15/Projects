import './App.css';

import { Routes, Route, useNavigate} from 'react-router-dom'

import Main from './views/Main'
import Create from './views/Create'

function App() {
  return (
    <div className="App">
      <Routes>
        <Route element={<Main/>} path="/" />
        <Route element={<Create/>} path="/create" />
        </Routes>
    </div>
  );
}

export default App;
