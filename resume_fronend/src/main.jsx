import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { BrowserRouter, Route, Routes } from './components/root';
import About from "./pages/About";
import Home from "./pages/Home";
import Root from "./pages/Root";

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
    
    <Routes path="/">

      <Route path="/" element={<Root/>}>
         <Route path="Home" element={<Home/>} />
         <Route path="About" element={<About/>} />
      </Route>
    </Routes>
    </BrowserRouter>
  </StrictMode>,
)
