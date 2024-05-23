import Navbar from './components/Navbar';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import NoteState from './context/notes/NoteState';
import Alert from './components/Alert';
import Login from './components/Login';
import Signup from './components/Signup';
import { useState } from 'react';

function App() {
  const [alert, setalert] = useState(null);

  const showAlert = (message, type)=> {
    setalert({msg:message, type: type});
    setTimeout(() => {
      setalert(null);
    }, 2000)
  }

  return (
    <>
    <NoteState>
        <Router>
        <Navbar/> 
        <Alert alert={alert}/> 
        <div className="container">
           <Routes>
              <Route path="/" element={<Home showAlert={showAlert}/>}/>
            </Routes>
            <Routes>
              <Route path="/about" element={<About/>}/>
            </Routes>
            <Routes>
              <Route path="/about"/>
            </Routes>
            <Routes>
              <Route path="/login" element={<Login showAlert={showAlert}/>}/>
            </Routes>
            <Routes>
              <Route path="/Signup" element={<Signup showAlert={showAlert}/>}/>
            </Routes>
        </div>
        </Router>
      </NoteState>
    </>
  );
}

export default App;
