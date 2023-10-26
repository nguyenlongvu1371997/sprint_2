import { date } from "yup";
import Header from "./Header";
import { useEffect, useState } from "react";
import { getMovieIsShowing } from "../service/MovieService";
import { getShowtimesNextDayByMovieId, getShowtimesNextNextDayByMovieId, getShowtimesTodayByMovieId } from "../service/ShowtimesService";
import { useNavigate } from "react-router-dom";
import moment from "moment/moment";

export default function ShowtimeList() {
    const [movies, setMovies] = useState([]);
    const [day, setDay] = useState(1);
    const today = moment().format('DD/MM/YYYY');
    const tomorrow = moment().add(1, 'days').format('DD/MM/YYYY');
    const dayAfterTomorrow = moment().add(2, 'days').format('DD/MM/YYYY');



    const navigate = useNavigate();

    useEffect(() => {
        getMovie();
    }, [])

    const getMovie = async () => {
        const res = await getMovieIsShowing();
        setMovies((pre) => res);
    }



    return (
        <>
            <Header />

            <div className="container row" style={{ marginTop: '200px' }}>
                <div className="row" >


                </div>
                <div className="col-8">
                    <select onChange={(event) => setDay(event.target.value)}>
                        <option value={1}>Today: {today}</option>
                        <option value={2}>Tomorrow: {tomorrow}</option>
                        <option value={3}>Next 2 day: {dayAfterTomorrow}</option>
                    </select>
                    {movies.map((movie) => (
                        <Movie key={movie.id} movie={movie} day={day} />
                    ))}

                </div>
                <div className="col-4">
                    <h1>
                        This is the place for advertising
                    </h1>

                </div>
            </div>
        </>
    )
}

function Movie({ movie, day }) {
    const [showtimes, setShowtime] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        if (movie.id > 0) {
            getShowtimesByMovie();
        }
    }, [day])

    const getShowtimesByMovie = async () => {
        if (day == 1) {
            const res = await getShowtimesTodayByMovieId(movie.id);
            setShowtime((pre) => res);
        } else if (day == 2) {
            const res = await getShowtimesNextDayByMovieId(movie.id);
            setShowtime((pre) => res);
        } else {
            const res = await getShowtimesNextNextDayByMovieId(movie.id);
            setShowtime((pre) => res);
        }
    }

    const toSeat = (id) => {
        navigate("/seats/" + id);
    }
    return (
        <>
            <div className="row mt-3" style={{ height: '200px' }}>
                <div className="col-2"><img src={movie.picture}></img></div>
                <div className="col-10">
                    <p>{movie.name}</p>
                    <p>Time: {movie.showingTime} minutes</p>
                    <div className="w-100 flex">
                        <div>
                            {showtimes.map((showtime) => (
                                <span onClick={() => toSeat(showtime.id)} key={showtime.id} className="mx-2 px-2 border border-light rounded-3">
                                    {showtime.timeShow.substring(11, 16)}
                                  
                                </span>
                            ))}


                        </div>


                    </div>
                </div>
                <hr className="mt-3"></hr>
            </div>
        </>
    )
} 