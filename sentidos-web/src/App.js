import Home from './pages/home/Home';
import css from "./App.css"
import { useState } from 'react';
import Context from './context/userContext';


function App() {
  const [user, setUser] = useState({username:"",token:false,loged:false});

  return (
    <Context.Provider   value={{user, setUser }}  >      
      <Home />
    </Context.Provider>
  );
}

export default App;
