import logo from './logo.svg';
import './App.css';
import Home from './component/Home';
import 'bootstrap/dist/css/bootstrap.css'
import "./css/home.css"
import { Route, Routes } from 'react-router-dom';
import Seats from './component/Seats';
import ShowtimeList from './component/ShowtimeList';
import LoginForm from './component/Login';
import axios from 'axios';
import { axiosClient } from './service/AppUserService';
import HistoryTicket from './component/HistoryTicket';

function App() {
  axiosClient();
  return (
    <Routes>
   <Route element={<Home />} path='/home' />
   <Route element={<Seats />} path='/seats/:id'/>
   <Route element={<ShowtimeList />} path='/showtime-list'/>
   <Route element={<LoginForm />} path='/login' />
   <Route element={<HistoryTicket />} path='/history-ticket' />
    </Routes>
  );
}

export default App;
