import logo from './logo.svg';
import './App.css';
import Home from './component/Home';
import 'bootstrap/dist/css/bootstrap.css'
import "./css/home.css"
import { Route, Routes } from 'react-router-dom';
import Seats from './component/Seats';
import ShowtimeList from './component/ShowtimeList';

function App() {
  return (
    <Routes>
   <Route element={<Home />} path='/home' />
   <Route element={<Seats />} path='/seats'/>
   <Route element={<ShowtimeList />} path='/showtime-list'/>
    </Routes>
  );
}

export default App;
