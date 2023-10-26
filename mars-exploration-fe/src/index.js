import React, { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import './index.css';


import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Home from './pages/Home';
import MapCreator from "./pages/MapCreator";
import ExplorationCreator from './pages/ExplorationCreator';
import Result from './pages/Result';

const App = () => {
  return (
  <>
    <Routes>
      <Route path="/" element={<Home />}></Route>
      <Route path="/map" element={<MapCreator />}></Route>
      <Route path="/exploration" element={<ExplorationCreator />}></Route>
      <Route path="/result/map" element={<Result />}></Route>
      <Route path="/result/exploration" element={<Result />}></Route>
    </Routes>
  </>
  );
}

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
      <App /> 
    </BrowserRouter>
  </StrictMode>
);