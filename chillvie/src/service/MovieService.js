import axios from "axios";

export async function getMovieIsShowing(){
    const res = await axios.get("http://localhost:8080/api/movie/showing");
    return res.data;
}

export async function getListShowingMovie(name){
    const res = await axios.get("http://localhost:8080/api/movie/showing-movie?name="+name);
    return res.data;
}

export async function getListUpcomingMovie(name){
    const res = await axios.get("http://localhost:8080/api/movie/upcoming-movie?name="+name);
    return res.data;
}

export async function getMovieById(id){
    const res = await axios.get("http://localhost:8080/api/movie/movie?id="+id);
    return res.data;
}