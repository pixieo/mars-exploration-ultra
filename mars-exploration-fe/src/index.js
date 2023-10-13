import React, { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import './index.css';


import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Home from './components/Home';
import MapCreator from "./components/MapCreator";
import ExploreCreator from './components/ExploreCreator';
import Result from './components/Result';

const App = () => {
  return (
  <>
    <Routes>
      <Route path="/" element={<Home />}></Route>
      <Route path="/map" element={<MapCreator />}></Route>
      <Route path="/explore" element={<ExploreCreator />}></Route>
      <Route path="/result/map" element={<Result />}></Route>
      <Route path="/result/explore" element={<Result />}></Route>
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