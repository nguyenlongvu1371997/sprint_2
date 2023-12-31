import axios from "axios";

export async function getShowtimesTodayByMovieId(id){
    const res = await axios.get("http://localhost:8080/api/showtimes/movie?id="+id);
    return res.data;
} 

export async function getShowtimesNextDayByMovieId(id){
    const res = await axios.get("http://localhost:8080/api/showtimes/movie-next-day?id="+id);
    return res.data;
} 

export async function getShowtimesNextNextDayByMovieId(id){
    const res = await axios.get("http://localhost:8080/api/showtimes/movie-next-next-day?id="+id);
    return res.data;
} 

export async function getShowtimeById(id){
    const res = await axios.get("http://localhost:8080/api/showtimes/showtime?id="+id);
    return res.data;
}