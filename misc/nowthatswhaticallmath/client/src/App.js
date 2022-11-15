import './App.css';
import React from 'react'
import {Routes, Route} from 'react-router-dom';

import Addition from './views/Addition'

function App() {

  return (
    <div className="App">
      <h1>Lets get mathmatical</h1>
      <Addition />
      <br/>
    </div>
  );
}

export default App;
