import './App.css';
import React from 'react'
import { Routes, Route } from 'react-router-dom';

import Main from './views/Main'
import Detail from './views/Detail'
import Update from './views/Update'
import New from './views/New'

function App() {
  return (
    <div className="App">
      <Routes>
        <Route element={<Main/>} path="/" />
        <Route element={<Detail/>} path="/:id" />
        <Route element={<Update/>} path="/goal/:id/edit"/>
        <Route element={<New/>} path="/goal/new"/>
      </Routes>
    </div>
  );
}

export default App;