import React from 'react';
import './App.css';
import Login from './Login';
import Container from './Container';
import {BrowserRouter, Routes,Route } from 'react-router-dom'

function App(){
  
	return (
		<div className="App">
		  
			<Login />
			
		</div>
	);
  
}


export default App;