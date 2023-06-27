import React, { useState } from 'react';
import { HashRouter, Route, Routes } from 'react-router-dom';
import { Home } from './components/Home';
import ViewSpecialistPage from './pages/ViewSpecialistPage';

const apiUrl = 'http://localhost:8080';

function App() {
//   const [cartItems, setCartItems] = useState([]);

  return (
    <div className="App">
      <HashRouter>
        <Home />
        <Routes>
          <Route path="/specialist" element={<ViewSpecialistPage />} />
  
        </Routes>
      </HashRouter>
    </div>
  );
}

export default App;

export { apiUrl };
